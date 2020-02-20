package com.example.gradesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.AssighnmentDAO;

public class AddAssignmentActivity extends AppCompatActivity {
    EditText detailsField;
    EditText assighnedDateField;
    EditText dueDateField;
    EditText categoryIDField;
    EditText courseIDField;
    EditText earnedScoreField;
    EditText maxScoreField;
    Button createButton;

    AssighnmentDAO AssighnmentDAOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        detailsField = findViewById(R.id.editText1);
        assighnedDateField = findViewById(R.id.editText2);
        dueDateField = findViewById(R.id.editText3);
        categoryIDField = findViewById(R.id.editText4);
        courseIDField = findViewById(R.id.editText5);
        earnedScoreField = findViewById(R.id.editText6);
        maxScoreField = findViewById(R.id.editText7);
        createButton = findViewById(R.id.SubmitButton);

        AssighnmentDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getAssighnmentDAO();

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssighnmentDAOReference.insert(new Assighnment(detailsField.getText().toString(), assighnedDateField.getText().toString(), dueDateField.getText().toString(), Integer.parseInt(categoryIDField.getText().toString()),
                        Integer.parseInt(courseIDField.getText().toString()), Float.parseFloat(earnedScoreField.getText().toString()), Float.parseFloat(maxScoreField.getText().toString())));
                Toast.makeText(getApplicationContext(),"Assighnment Added",Toast.LENGTH_LONG).show();
            }
        });
    }
}
