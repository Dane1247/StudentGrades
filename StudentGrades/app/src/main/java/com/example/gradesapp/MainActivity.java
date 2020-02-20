package com.example.gradesapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.UserDAO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;
    private Button btCreateAcc;
    private EditText editUsername;
    private EditText editPassword;
    private AppDatabase database;

    private UserDAO userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);


        database = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDAO();


        btLogin = findViewById(R.id.LoginButton);
        btCreateAcc = findViewById(R.id.CreateAcc_Button);

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);


        // Create Account Activity
        btCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
                finish();
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(editUsername.getText().toString(), editPassword.getText().toString());
                            if(user!=null){
                                Intent i = new Intent(MainActivity.this, UserDashboard.class);
                                i.putExtra("User", user.getStudentID());
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);

                }else{
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(editUsername.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}
