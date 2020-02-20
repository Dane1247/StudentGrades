package com.example.gradesapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.UserDAO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editUsername;
    private EditText editPassword;

    private Button btCancel;
    private Button btRegister;

    private UserDAO userDao;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);


        editFirstName = findViewById(R.id.create_account_first_name_edit_text);
        editLastName = findViewById(R.id.create_account_last_name_edit_text);
        editUsername = findViewById(R.id.create_account_username_edit_text);
        editPassword = findViewById(R.id.create_account_password_edit_text);

        btCancel = findViewById(R.id.create_account_cancel_button);
        btRegister = findViewById(R.id.create_account_submit_button);

        userDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
                finish();
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {

                    //progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(editFirstName.getText().toString(), editLastName.getText().toString(),
                                    editUsername.getText().toString(), editPassword.getText().toString());
                            userDao.insert(user);
                            //progressDialog.dismiss();
                            startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
                        }
                    }, 1000);

                } else {
                    Toast.makeText(CreateAccountActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(editUsername.getText().toString()) ||
                TextUtils.isEmpty(editPassword.getText().toString()) ||
                TextUtils.isEmpty(editFirstName.getText().toString()) ||
                TextUtils.isEmpty(editLastName.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
