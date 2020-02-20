package com.example.gradesapp;

/* // Sean
    This class is somewhat redundant giving that there is already a User class,
    but I'm thinking that for now it is a decent way to outsource the logic of
    validating new user credentials from the CreateAccount activity.
 */

import com.example.gradesapp.DB.UserDAO;

import java.util.List;

// Sean
public class NewUserCredentials {

    // Sean
    private String firstname;
    // Sean
    private String lastname;
    // Sean
    private String username;
    // Sean
    private String password;
    // Sean
    private String passConf;
    // Sean
    private UserDAO userDAO;

    // Sean
    public NewUserCredentials(
            String firstname,
            String lastname,
            String username,
            String password,
            String passConf,
            UserDAO userDAO
    ){
        this.firstname = firstname;
        this.lastname  = lastname;
        this.username  = username.toLowerCase();
        this.password  = password;
        this.passConf  = passConf;
        this.userDAO   = userDAO;
    }

    // Sean
    public String getFirstname(){ return this.firstname; }
    // Sean
    public String getLastname(){ return this.lastname; }
    // Sean
    public String getUsername(){ return this.username; }
    // Sean
    public String getPassword(){ return this.password; }
    // Sean
    public String getPassConf(){ return this.passConf; }

    // Sean
    public boolean passwordMatches() {
        return this.getPassConf().equals(this.getPassword());
    }

    // Sean
    public boolean passwordDoesntMatch(){
        return !this.passwordMatches();
    }

    // Sean
    // get a list of users with this.username and if there is one or more,
    // returns true to indicate that the username is taken.
    public boolean usernameTaken(){
        List<User> query = this.userDAO.getUserFromUsername(this.getUsername());
        if ( query.size() >= 1 ){
            return true;
        }
        return false;
    }

    // Sean
    // if any field is empty or null it returns true, otherwise it returns false
    public boolean missingFields(){
        return (
                (this.getFirstname() ==  null || this.getFirstname().equals("")) ||
                        (this.getLastname()  ==  null || this.getLastname().equals(""))  ||
                        (this.getUsername()  ==  null || this.getUsername().equals(""))  ||
                        (this.getPassword()  ==  null || this.getPassword().equals(""))  ||
                        (this.getPassConf()  ==  null || this.getPassConf().equals(""))
        );
    }

    // Sean
    // writes the credentials to the database
    public void save(){
        User newUser = new User(
                this.getUsername(),
                this.getPassword(),
                this.getFirstname(),
                this.getLastname()
        );
        this.userDAO.insert(newUser);
    }

    // Sean
    @Override
    public String toString(){
        return(
                "\nFirstName: " + this.getFirstname() + "\n" +
                        "Lastname : "   + this.getLastname() + "\n" +
                        "Username : "   + this.getUsername() + "\n" +
                        "Password : "   + this.getPassword() + "\n" +
                        "PassConf : "   + this.getPassConf() + "\n"
        );
    }
}
