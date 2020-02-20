package com.example.gradesapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.AssignmentDAO;
import com.example.gradesapp.DB.GradeCategoryDAO;
import com.example.gradesapp.DB.GradeDAO;

public class AddAssignmentActivity extends AppCompatActivity {
    EditText name;
    EditText pointsPossible;
    EditText pointsEarned;
    EditText dateAssigned;
    EditText dueDate;
    EditText type;
    EditText weight;
    Button   addAssignmentButton;
    Button   cancelActivityButton;

    Integer currentCourseID;
    Integer currentUserID;

    AssignmentDAO assignmentDAO;
    GradeCategoryDAO gradeCategoryDAO;
    GradeDAO gradeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        // Sean
        // set up member variables
        this.set_up_member_variables();

        // Sean
        // set up the DAOs
        this.set_up_daos(this);

        // Sean
        // set up click behavior for add assignment button
        this.set_up_add_assignment_button();

        // Sean
        // Set up cancel button
        this.set_up_cancel_button();
    }

    private void set_up_cancel_button(){
        this.cancelActivityButton = findViewById(R.id.add_assignment_cancel_button);
        this.cancelActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    private void set_up_add_assignment_button(){
        this.addAssignmentButton = (Button)findViewById(R.id.add_assignment_add_assignment_button);
        this.addAssignmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddAssignmentActivity.this.add_assignment_button_was_clicked();
            }
        });
    }

    private void add_assignment_button_was_clicked(){
        if ( this.missing_fields() ){
            return;
        }

        Assignment assignment = new Assignment(
            this.name.getText().toString(),
            this.dateAssigned.getText().toString(),
            this.dueDate.getText().toString(),
            0, // to be changed right away
            this.currentCourseID,
            Float.parseFloat(this.pointsEarned.getText().toString()),
            Float.parseFloat(this.pointsPossible.getText().toString())
        );

        // calculate the score -> a String like "XX%"
        Float pointsEarnedAsFloat = Float.parseFloat(this.pointsEarned.getText().toString());
        Float pointsPossibleAsFloat = Float.parseFloat(this.pointsPossible.getText().toString());
        String score = new Float(pointsEarnedAsFloat/pointsPossibleAsFloat).toString() + "%";

        Grade grade = new Grade(
            score,
            assignment.getDueDate(),
            assignment.getAssignmentID(),
            this.currentUserID,
            this.currentCourseID
        );

        GradeCategory gradeCategory = new GradeCategory(
            this.type.getText().toString(),
            grade.getGradeID(),
            this.dateAssigned.getText().toString(),
            Float.parseFloat(this.weight.getText().toString())
        );

        this.assignmentDAO.insert(assignment);


        finish();
    }

    private void set_up_member_variables(){
        this.name                = findViewById(R.id.add_assignment_assignment_name_edit_text);
        this.pointsPossible      = findViewById(R.id.add_assignment_points_possible_edit_text);
        this.pointsEarned        = findViewById(R.id.add_assignment_points_earned_edit_text);
        this.dateAssigned        = findViewById(R.id.add_assignment_date_assigned_edit_text);
        this.dueDate             = findViewById(R.id.add_assignment_due_date_edit_text);
        this.type                = findViewById(R.id.add_assignment_type_edit_text);
        this.weight              = findViewById(R.id.add_assignment_weight_edit_text);

        Bundle extras = getIntent().getExtras();
        this.currentCourseID = extras.getInt("COURSE_ID");
        this.currentUserID = extras.getInt("USER_ID");
        System.out.println("Current shit");
        System.out.println(this.currentCourseID);
        System.out.println(this.currentUserID);
    }

    private void set_up_daos(Context c){
        this.assignmentDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getAssignmentDAO();

        this.gradeCategoryDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getGradeCategoryDAO();

        this.gradeDAO = Room.databaseBuilder(
                c,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getGradeDAO();
    }

    private boolean missing_fields(){
        boolean bad = false;
        if ( this.name.getText().toString().equals("") ){
            this.name.setHintTextColor(Color.RED);
            bad = true;
        }
        if ( this.pointsPossible.getText().toString().equals("") ){
            this.pointsPossible.setHintTextColor(Color.RED);
            bad = true;
        }
        if ( this.pointsEarned.getText().toString().equals("") ){
            this.pointsEarned.setHintTextColor(Color.RED);
            bad = true;
        }
        if ( this.type.getText().toString().equals("") ){
            this.type.setHintTextColor(Color.RED);
            bad = true;
        }
        if ( this.weight.getText().toString().equals("") ){
            this.weight.setHintTextColor(Color.RED);
            bad = true;
        }
        return bad;
    }
}
