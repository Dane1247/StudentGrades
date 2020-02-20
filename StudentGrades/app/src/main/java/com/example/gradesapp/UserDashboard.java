package com.example.gradesapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.CourseDAO;
import com.example.gradesapp.DB.UserDAO;
import com.example.gradesapp.User;

import java.util.List;

public class UserDashboard extends AppCompatActivity {

    private TextView tvUser;

    private UserDAO userDAOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        final int userID = getIntent().getExtras().getInt("User");

/*        tvUser = findViewById(R.id.tvUser);

        if (user != null) {
            tvUser.setText("WELCOME "+ user() +" "+user.getLastName());
        }*/

        userDAOReference = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        tvUser = findViewById(R.id.tvUser);

        List<User> user = userDAOReference.getUserWithId(userID);
        String name = user.get(0).getFirstName() + " " + user.get(0).getLastName();
        //tvUser.setText("Hello, ".concat(name));
        tvUser.setText("Hello, " + name);
        Toast.makeText(UserDashboard.this, name, Toast.LENGTH_SHORT).show();
        //System.out.println(name);
    }
}
