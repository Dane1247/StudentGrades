package com.example.gradesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.CourseDAO;
import com.example.gradesapp.DB.GradeDAO;
import com.example.gradesapp.DB.UserDAO;
import com.example.gradesapp.DB.EnrollmentDAO;

import java.util.Iterator;
import java.util.List;

public class UserDashboard extends AppCompatActivity {

    private UserDAO userDAOReference;
    private EnrollmentDAO enrollmentDAOReference;
    private CourseDAO courseDAOReference;
    private GradeDAO gradeDAOReference;
    private List<String> data; // list of courses (name and grade)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        ListView lv = findViewById(R.id.listview);
        final int userID = getIntent().getExtras().getInt("userID");
        getDAOs();

        List<Enrollment> courses = enrollmentDAOReference.getEnrollmentsWithStudentID(userID);

        generateListContent(courses);
        lv.setAdapter(new MyListAdaper(this, R.layout.list_item, data));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CourseDashboard.class);
                intent.putExtra("courseID", "courseID");
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }

    private void getDAOs() {
        userDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
        enrollmentDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getEnrollmentDAO();
        courseDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();
        gradeDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getGradeDAO();
    }

    private String getGrade(int courseid){
        List<Grade> grade = gradeDAOReference.getGradeWithCourseID(courseid);
        return grade.get(0).score;
    }

    private void generateListContent(List<Enrollment> courseid) {
        Iterator iterator = courseid.iterator();
        while(iterator.hasNext()) {
            List<Course> course = (List<Course>) iterator.next();
            List<Course> courses = courseDAOReference.getCoursesWithCourseID(course.get(0).getCourseID());
            data.add(courses.get(0).getTitle() + getGrade(courses.get(0).getCourseID()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;

        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.title = convertView.findViewById(R.id.list_item_text);
                convertView.setTag(viewHolder);
            }

            mainViewholder = (ViewHolder) convertView.getTag();
            mainViewholder.title.setText(getItem(position));
            return convertView;

        }
    }

    public class ViewHolder {
        TextView title;
    }

}