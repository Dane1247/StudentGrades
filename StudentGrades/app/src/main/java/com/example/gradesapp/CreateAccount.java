package com.example.gradesapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
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
     */
    private void submit_button_was_clicked(){
        // gets the user input from the view elements
        String firstname = ((EditText) findViewById(R.id.create_account_first_name_edit_text)).getText().toString();
        String lastname  = ((EditText) findViewById(R.id.create_account_last_name_edit_text)).getText().toString();
        String username  = ((EditText) findViewById(R.id.create_account_username_edit_text)).getText().toString();
        String password  = ((EditText) findViewById(R.id.create_account_password_edit_text)).getText().toString();
        String passConf  = ((EditText) findViewById(R.id.create_account_password_confirm_edit_text)).getText().toString();

        // puts that data into a NewUserCredentials object
        NewUserCredentials credentials = new NewUserCredentials(
            firstname,
            lastname,
            username,
            password,
            passConf
        );

        // Just for debugging
        System.out.println( credentials );

        // There are various things that could go wrong
        // for each one a methods is called to deal with it
        if ( credentials.missingFields() ){
            this.handle_missing_fields();
            return;
        }
        if ( credentials.usernameTaken() ){
            this.handle_username_taken();
            return;
        }
        if ( credentials.passwordDoesntMatch() ){
            this.handle_password_doesnt_match();
            return;
        }

        // Sean
        // by this point no errors should exist
        // time to save the new user info and return to main activiy
        this.create_account(credentials);
    }

    /* // Sean
     called when cancel button was clicked, goes back to main activity
     Should cancel behave like the back button?? just go to last activity?
     not exclusively main activity?
    */

    private void cancel_button_was_clicked(){
        finish();
        //Intent i = new Intent(CreateAccount.this, MainActivity.class);
        //startActivity(i);
    }

    // Sean
    private void handle_username_taken(){
        TextView messageBar = (TextView) findViewById(R.id.create_account_message_bar_text_view);
        messageBar.setText("Username Taken");
        messageBar.setTextColor(Color.RED);
        System.out.println("Username taken");
    }

    // Sean
    private void handle_password_doesnt_match(){
        TextView messageBar = (TextView) findViewById(R.id.create_account_message_bar_text_view);
        messageBar.setText("Passwords Did Not Match");
        messageBar.setTextColor(Color.RED);
        System.out.println("Passwords don't match");
    }

    // Sean
    private void handle_missing_fields(){
        TextView messageBar = (TextView) findViewById(R.id.create_account_message_bar_text_view);
        messageBar.setText("Please fill all fields");
        messageBar.setTextColor(Color.RED);
        System.out.println("Passwords don't match");
    }

    // Sean
    private void create_account(NewUserCredentials credentials){
        // change message bar to "Success!"
        TextView messageBar = (TextView) findViewById(R.id.create_account_message_bar_text_view);
        messageBar.setText("Success!");
        messageBar.setTextColor(Color.GREEN);
        // for debugging
        System.out.println("Account Created Successfully");

        // write new user to database
        credentials.save();

        // finish activity
        finish();
    }
}
