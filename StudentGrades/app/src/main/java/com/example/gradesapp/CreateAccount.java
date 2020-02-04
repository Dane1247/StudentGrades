package com.example.gradesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);
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

        // setting up the click behavior of the create account page submit button
        set_up_submit_button();
    }


    /*
        adds the onClick listener to the create account submit button
     */
    private void set_up_submit_button(){
        Button submit = (Button) findViewById(R.id.create_account_submit_button);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CreateAccount.this.submit_button_was_clicked();
            }
        });
    }

    /*
        the method to be called from within onClick from the click listener within
        the submit button.
     */
    private UserCredentials submit_button_was_clicked(){
        String username = ((EditText) findViewById(R.id.create_account_username_edit_text)).getText().toString();
        String password = ((EditText) findViewById(R.id.create_account_password_edit_text)).getText().toString();
        String passConf = ((EditText) findViewById(R.id.create_account_password_confirm_edit_text)).getText().toString();
        System.out.println( "\n" + username + "\n" + password + "\n" + passConf);

        return new UserCredentials(username, password, passConf);
    }


    /*
        This method will check to see that the username provided by the user
        does not already exist.
        It will also check to make sure that the password and password confirmation
        values are identical.
     */
    public boolean credentials_are_valid(UserCredentials credentials){
        if ( credentials.usernameTaken() ){
            // do something about it
            return false;
        }
        if ( credentials.passwordMatches() ){
            // do something about it
            return false;
        }
        return true;
    }
}
