package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int key;

    String username,password,firstName,lastName,userID;

    public User(String inputUsername, String inputPassword,
                String inputFirstName, String inputLastName,String inputUserID){
        username = inputUsername;
        password = inputPassword;
        firstName = inputFirstName;
        lastName = inputLastName;
        userID = inputUserID;
    }

<<<<<<< HEAD
=======
    public User(){
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        userID = "";
    }

>>>>>>> parent of a244bd5... made initial database changes
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
<<<<<<< HEAD
    }

    public void setUserID(String userID) {
        this.userID = userID;
=======
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + '\n' +
                "Username: " + username + '\n' +
                "Password: " + password + '\n' +
                "First Name='" + firstName + '\n' +
                "Last Name='" + lastName;
>>>>>>> parent of a244bd5... made initial database changes
    }
}
