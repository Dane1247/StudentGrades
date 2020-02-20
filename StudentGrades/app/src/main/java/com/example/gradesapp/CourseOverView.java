package com.example.gradesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.AssignmentDAO;
import com.example.gradesapp.DB.CourseDAO;
import com.example.gradesapp.DB.UserDAO;

import java.util.List;

public class CourseOverView extends AppCompatActivity {

    User currentUser;
    Course currentCourse;

    UserDAO userDAO;
    CourseDAO courseDAO;
    AssignmentDAO assignmentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_over_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Sean
        // initializes this classes DAO references.
        this.build_daos(this);

        // Sean
        // initializes this classes currentUser and currentCourse member variables.
        this.load_user_and_course_from_extra();

        // Sean
        // load relevent data
        this.fill_page_with_course_information(this);

        // Sean
        // add listner to add assignment button
        this.set_up_add_assignment_button();
    }

    private void set_up_add_assignment_button(){
        Button addAss = (Button) findViewById(R.id.course_view_add_assignment_button);
        addAss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(CourseOverView.this, AddAssignmentActivity.class);
                startActivity(i);
            }
        });
    }


    // Sean
    // a struct for holding an assignment summary
    class AssignmentListItem {
        String name;
        Float gradePercent;

        AssignmentListItem(String name, Float gradePercent){
            this.name = name;
            this.gradePercent = gradePercent;
        }
    }

    // Sean
    // a list of AssignmentListItems for the recycler view
    private List<AssignmentListItem> assignments;
    // Sean
    // Populate page with course information
    private void fill_page_with_course_information(Context c){
        TextView courseTitle = (TextView) findViewById(R.id.course_over_view_course_title_text_view);
        courseTitle.setText(this.currentCourse.getTitle());

        TextView courseDescription = (TextView) findViewById(R.id.course_over_view_course_description_text_view);
        courseDescription.setText(this.currentCourse.getDescription());

        RecyclerView listView = (RecyclerView)findViewById(R.id.course_view_assignemnt_list_recycler_view);
        listView.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(c);
        listView.setLayoutManager(layout);
    }

    // Sean
    // build DAOs, and assign them to this classes DAO member variables.
    private void build_daos(Context c){
        this.userDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getUserDAO();
        this.courseDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getCourseDAO();
        this.assignmentDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getAssignmentDAO();
    }

    // Sean
    // User and course will be used a lot, load them into member variables
    private void load_user_and_course_from_extra(){
        Bundle extras = getIntent().getExtras();
        int user_id = extras.getInt("USER_ID");
        int course_id = extras.getInt("COURSE_ID");
        this.currentUser = this.userDAO.getUserWithId(user_id).get(0);
        this.currentCourse = this.courseDAO.getCoursesWithCourseID(course_id).get(0);
    }

}
