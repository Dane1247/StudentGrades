package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADE_TABLE)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int gradeID;
    String score,assighnmentID,studentID,courseID,dateEarned;

    public Grade(String score, String assighnmentID, String studentID, String courseID, String dateEarned) {
        this.score = score;
        this.assighnmentID = assighnmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.dateEarned = dateEarned;
    }

    public Grade() {
        this.score = "";
        this.assighnmentID = "";
        this.studentID = "";
        this.courseID = "";
        this.dateEarned = "";
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAssighnmentID() {
        return assighnmentID;
    }

    public void setAssighnmentID(String assighnmentID) {
        this.assighnmentID = assighnmentID;
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

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    @Override
    public String toString() {
        return  "Grade ID: " + gradeID + '\n' +
                "Assighnment ID: " + assighnmentID + '\n' +
                "Student ID: " + studentID + '\n' +
                "Course ID: " + courseID + '\n' +
                "Score: " + score + '\n' +
                "Date Earned: " + dateEarned;
    }
}
