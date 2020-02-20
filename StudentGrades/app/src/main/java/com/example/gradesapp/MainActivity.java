package com.example.gradesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.AssignmentDAO;
import com.example.gradesapp.DB.CourseDAO;
import com.example.gradesapp.DB.UserDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public static final String USER_ID = "USER_ID"; // delete for production
    public static final String COURSE_ID = "COURSE_ID"; // delete for production

    private int courseID; // delete for production
    private int userID;   // delete for production

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.nuke_all(this);

        // Sean
        // sets up dummy data that I can use to test CourseOverview
        delete_for_production_add_dummy_data_to_database_for_testing_course_overview(this);

        // Sean
        // only here to give me access to create account activity
        delete_for_production_set_up_create_account_button();

        // Sean
        // only here to give me access to the Course Overview activity
        delete_for_production_set_up_go_to_course_overview_button();
    }

    private void nuke_all(Context c){
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getUserDAO().nukeTable();
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getAssignmentDAO().nukeTable();
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getCourseDAO().nukeTable();
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getEnrollmentDAO().nukeTable();
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getGradeCategoryDAO().nukeTable();
        Room.databaseBuilder(c, AppDatabase.class, AppDatabase.dbName).allowMainThreadQueries().build().getGradeDAO().nukeTable();
    }

    // Sean
    // I added a button to the main activity soley to give me access to the createAccount activity.
    private void delete_for_production_set_up_create_account_button(){
        Button createAccount = (Button) findViewById(R.id.main_activity_create_account_button);
        createAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(i);
            }
        });
    }

    // Sean
    // make a button to go to the course over view activity
    public void delete_for_production_set_up_go_to_course_overview_button(){
        Button goToCourseOverview = (Button) findViewById(R.id.go_to_test_over_view);
            goToCourseOverview.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent i = new Intent(MainActivity.this, CourseOverView.class);
                    i.putExtra(USER_ID, MainActivity.this.userID);
                    i.putExtra(COURSE_ID, MainActivity.this.courseID);
                    startActivity(i);
                }
            });
    }

    // Sean
    // add dummy data to DB if not already there, gets the course id and user id and gives it to
    // temporary member variables.
    public void delete_for_production_add_dummy_data_to_database_for_testing_course_overview(Context c){
        UserDAO userDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getUserDAO();

        CourseDAO courseDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getCourseDAO();

        AssignmentDAO assignmentDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getAssignmentDAO();


        if ( ! (userDAO.getUserFromUsername("seantowne").size() >= 1) ) {
            User testUser = new User(
                    "seantowne",
                    "password",
                    "firstname",
                    "lastname"
            );
            userDAO.insert(testUser);
        }

        if ( ! (courseDAO.getCoursesWithTitle("cst438").size() >= 1) ) {
            Course testCourse = new Course(
                    "Dr.C",
                    "cst438",
                    "software engineering",
                    "01.02.1993",
                    "14.03.1994"
            );
            courseDAO.insert(testCourse);
        }


        this.courseID = courseDAO.getCoursesWithTitle("cst438").get(0).getCourseID();
        this.userID = userDAO.getUserFromUsername("seantowne").get(0).getStudentID();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
