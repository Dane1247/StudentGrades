package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.ENROLLMENT_TABLE)
public class Enrollment {
    @PrimaryKey(autoGenerate = true)
    private int key;
    String studentID,courseID,enrollmentDate;

    public Enrollment(String studentID, String courseID, String enrollmentDate) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment() {
        this.studentID = "";
        this.courseID = "";
        this.enrollmentDate = "";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
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
