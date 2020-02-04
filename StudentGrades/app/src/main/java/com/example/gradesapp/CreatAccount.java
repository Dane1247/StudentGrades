package com.example.gradesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CreatAccount extends AppCompatActivity {

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
        SEAN_set_up_submit_button();
    }

    /*
        python lets you return a bunch of stuff as an array,
        java doesn't, so this class is a hack to be able to
        carry around these three string variable with one
        reference.
     */
    private class Credentials {
        public Credentials(String username, String password, String passConf){
            this.username = username;
            this.password = password;
            this.passConf = passConf;
        }
        public String username;
        public String password;
        public String passConf;
    }

    /*
        adds the onClick listener to the create account submit button
     */
    private void SEAN_set_up_submit_button(){
        Button submit = (Button) findViewById(R.id.create_account_submit_button);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CreatAccount.this.SEAN_submit_button_was_clicked();
            }
        });
    }

    /*
        the method to be called from within onClick from the click listener within
        the submit button.
     */
    private Credentials SEAN_submit_button_was_clicked(){
        String username = ((EditText) findViewById(R.id.create_account_username_edit_text)).getText().toString();
        String password = ((EditText) findViewById(R.id.create_account_password_edit_text)).getText().toString();
        String passConf = ((EditText) findViewById(R.id.create_account_password_confirm_edit_text)).getText().toString();
        System.out.println( "\n" + username + "\n" + password + "\n" + passConf);

        return new Credentials(username, password, passConf);
    }

    /*
        *should return true if String username already exists in database
     */
    private boolean SEAN_username_already_exits(String username){
        return false;
    }


    /*
        This method will chech to see that the username provided by the user
        does not already exist.
        It will also check to make sure that the password and password confirmation
        values are identical.
     */
    private void SEAN_validate_new_user_credentials(Credentials credentials){
        if ( this.SEAN_username_already_exits(credentials.username) ){
            // do something about it
            // return
        }
        if ( !credentials.password.equals(credentials.passConf) ){
            // do something about it
            // return
        }

    }
}
