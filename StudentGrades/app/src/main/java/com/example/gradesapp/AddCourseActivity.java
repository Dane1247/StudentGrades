package com.example.gradesapp;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AddCourseActivity extends AppCompatActivity {

    private EditText editCourseTitle;
    private EditText editCourseInstructor;
    private EditText editCourseDescription;
    private EditText editCourseStart;
    private EditText editCourseEnd;
    //private EditText courseID;
    Button addCourseButton;

    private CourseDAO CourseDAOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        editCourseTitle = findViewById(R.id.courseTitle);
        editCourseInstructor = findViewById(R.id.courseInstructor);
        editCourseDescription  = findViewById(R.id.courseDescription);
        editCourseStart  = findViewById(R.id.courseStart);
        editCourseEnd  = findViewById(R.id.courseEnd);

        Toolbar toolbar = findViewById(R.id.toolbar);

        CourseDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseDAOReference.insert(new Course(editCourseTitle.getText().toString(), editCourseInstructor.getText().toString(), editCourseDescription.getText().toString(),
                        editCourseStart.getText().toString(), editCourseEnd.getText().toString()));
                Toast.makeText(getApplicationContext(),"Course Added",Toast.LENGTH_LONG).show();
            }
        });

        setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Course");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
