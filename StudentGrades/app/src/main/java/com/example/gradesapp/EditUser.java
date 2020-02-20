package com.example.gradesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.UserDAO;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class EditUser extends AppCompatActivity {

    private UserDAO userDAOReference;
    private EditText currentPW;
    private EditText newPW;
    private TextView welcome;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        final int userID = getIntent().getExtras().getInt("userID");
        currentPW = findViewById(R.id.currentPW);
        newPW = findViewById(R.id.newPW);
        welcome = findViewById(R.id.welcome);
        submit = findViewById(R.id.button);


        userDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        final List<User> user = userDAOReference.getUserWithId(userID);
        String name = user.get(0).getFirstName() + " " + user.get(0).getLastName();
        welcome.setText("Hello, " + name);

        final String realPassword = user.get(0).getPassword();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = currentPW.getText().toString();
                String newPassword = newPW.getText().toString();

                if(password.equals(realPassword) && !newPassword.equals(password) ){
                    user.get(0).setPassword(newPassword);
                    User newUser = user.get(0);
                    userDAOReference.update(newUser);
                    Intent intent = new Intent(v.getContext(), UserDashboard.class);
                    intent.putExtra("userID", userID);
                    Toast.makeText(getApplicationContext(),"Updated Password" ,Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
