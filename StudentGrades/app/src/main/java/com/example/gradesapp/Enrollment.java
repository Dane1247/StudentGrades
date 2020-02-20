package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.ENROLLMENT_TABLE)
public class Enrollment {
    @PrimaryKey(autoGenerate = true)
    private int key;
    int studentID,courseID;
    String enrollmentDate;

    public Enrollment(int studentID, int courseID, String enrollmentDate) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment() {
        this.studentID = -1;
        this.courseID = -1;
        this.enrollmentDate = "";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + '\n' +
                "Course ID: " + courseID + '\n' +
                "Enrollment Date: " + enrollmentDate;

    }
    //
}