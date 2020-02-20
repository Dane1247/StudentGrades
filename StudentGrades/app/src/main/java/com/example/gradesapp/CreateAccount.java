package com.example.gradesapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.UserDAO;

public class CreateAccount extends AppCompatActivity {

    private UserDAO userDAO;
    private NewUserCredentials credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Sean
        // Creates the user DAO used to make new users/check against database
        this.userDAO = Room.databaseBuilder(
                this,
                AppDatabase.class,
                AppDatabase.dbName
        ).allowMainThreadQueries().build().getUserDAO();

        // Sean
        // setting up the click behavior of the create account page submit button
        set_up_submit_button();

        // Sean
        // setting up the click behavior of the create account page cancel button
        set_up_cancel_button();
    }


    // Sean
    // adds on click listener to submit button
    private void set_up_submit_button(){
        Button submit = (Button) findViewById(R.id.create_account_submit_button);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CreateAccount.this.submit_button_was_clicked();
            }
        });
    }

    // Sean
    // adds on click listener to cancel button
    private void set_up_cancel_button(){
        Button cancel = (Button) findViewById(R.id.create_account_cancel_button);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CreateAccount.this.cancel_button_was_clicked();
            }
        });
    }

    /* // Sean
        the method to be called from within onClick from the click listener within
        the submit button.

        It gets the data the user entered into the text fields

        creates a NewUserCredentials object with it

        prints it just for a sanity check

        checks for missing fields

        checks for username taken

        checks for password mismatch

        if all is well, it saves the new user to the DB
     */
    private void submit_button_was_clicked(){
        // gets the user input from the view elements
        String firstname = ((EditText) findViewById(R.id.create_account_first_name_edit_text)).getText().toString();
        String lastname  = ((EditText) findViewById(R.id.create_account_last_name_edit_text)).getText().toString();
        String username  = ((EditText) findViewById(R.id.create_account_username_edit_text)).getText().toString();
        String password  = ((EditText) findViewById(R.id.create_account_password_edit_text)).getText().toString();
        String passConf  = ((EditText) findViewById(R.id.create_account_password_confirm_edit_text)).getText().toString();

        // puts that data into a NewUserCredentials object
        this.credentials = new NewUserCredentials(
            firstname,
            lastname,
            username,
            password,
            passConf,
            this.userDAO
        );

        // Just for debugging
        System.out.println( this.credentials );

        // There are various things that could go wrong
        // for each one a methods is called to deal with it
        if ( this.credentials.missingFields() ){
            this.handle_missing_fields();
            return;
        }
        if ( this.credentials.usernameTaken() ){
            this.handle_username_taken();
            return;
        }
        if ( this.credentials.passwordDoesntMatch() ){
            this.handle_password_doesnt_match();
            return;
        }

        // Sean
        // by this point no errors should exist
        // time to save the new user info and return to main activity
        this.create_account();
    }

    // Sean
    private void cancel_button_was_clicked(){
        finish();
    }

    // Sean
    private void handle_username_taken(){
        this.change_message_bar_text("Username Taken", Color.RED);
        System.out.println("Username taken");
    }

    // Sean
    private void handle_password_doesnt_match(){
        this.change_message_bar_text("Passwords Do Not Match", Color.RED);
        System.out.println("Passwords don't match");
    }

    // Sean
    private void handle_missing_fields(){
        this.change_message_bar_text("Please Fill All Fields", Color.RED);
        System.out.println("missing fields");
    }

    // Sean
    private void create_account(){
        // change message bar to "Success!"
        this.change_message_bar_text("Success!", Color.GREEN);

        // for debugging
        System.out.println("Account Created Successfully");

        // write new user to database
        this.credentials.save();

        // finish activity
        finish();
    }

    // Sean
    private void change_message_bar_text(String newText, int newColor){
        TextView messageBar = (TextView) findViewById(R.id.create_account_message_bar_text_view);
        messageBar.setText(newText);
        messageBar.setTextColor(newColor);
    }
}
