package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int studentID;

    String username,password,firstName,lastName;

    public User(
            String inputUsername,
            String inputPassword,
            String inputFirstName,
            String inputLastName
    ){
        username = inputUsername;
        password = inputPassword;
        firstName = inputFirstName;
        lastName = inputLastName;
    }

    public User(){
        username = "";
        password = "";
        firstName = "";
        lastName = "";
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

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + '\n' +
                "Username: " + username + '\n' +
                "Password: " + password + '\n' +
                "First Name='" + firstName + '\n' +
                "Last Name='" + lastName;
    }
    //
}