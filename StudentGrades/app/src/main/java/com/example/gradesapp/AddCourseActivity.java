package com.example.gradesapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.CourseDAO;
import com.example.gradesapp.DB.UserDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AddCourseActivity extends AppCompatActivity {


    private UserDAO userDAOReference;
    private EditText editCourseTitle;
    private EditText editCourseInstructor;
    private EditText editCourseDescription;
    private EditText editCourseStart;
    private EditText editCourseEnd;
    //private EditText courseID;
    private Button addCourseButton;

    private CourseDAO courseDAOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        // pass in current userID
        final int userID = getIntent().getExtras().getInt("userID");

        editCourseTitle = findViewById(R.id.courseTitle);
        editCourseInstructor = findViewById(R.id.courseInstructor);
        editCourseDescription  = findViewById(R.id.courseDescription);
        editCourseStart  = findViewById(R.id.courseStart);
        editCourseEnd  = findViewById(R.id.courseEnd);

        addCourseButton = findViewById(R.id.addCourseButton);

        Toolbar toolbar = findViewById(R.id.toolbar);

        userDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        courseDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        final List<User> user = userDAOReference.getUserWithId(userID);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseDAOReference.insert(new Course(editCourseTitle.getText().toString(), editCourseInstructor.getText().toString(), editCourseDescription.getText().toString(),
                        editCourseStart.getText().toString(), editCourseEnd.getText().toString()));
                Intent i = new Intent(v.getContext(), UserDashboard.class);
                i.putExtra("userID", userID);
                Toast.makeText(getApplicationContext(),"Course Added",Toast.LENGTH_LONG).show();
                startActivity(i);
                finish();
            }
        });

    }

}
