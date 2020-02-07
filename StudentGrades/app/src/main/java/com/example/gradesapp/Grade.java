package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADE_TABLE)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int key;

    String score,assighnmentID,studentID,courseID,gradeEarned,gradeID;

    public Grade(String score, String assighnmentID, String studentID, String courseID, String gradeEarned, String gradeID) {
        this.score = score;
        this.assighnmentID = assighnmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.gradeEarned = gradeEarned;
        this.gradeID = gradeID;
    }

    public Grade() {
        this.score = "";
        this.assighnmentID = "";
        this.studentID = "";
        this.courseID = "";
        this.gradeEarned = "";
        this.gradeID = "";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
        return gradeEarned;
    }

    public void setDateEarned(String gradeEarned) {
        this.gradeEarned = gradeEarned;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    @Override
    public String toString() {
        return "Score: " + score + '\n' +
                "Assighnment ID: " + assighnmentID + '\n' +
                "Student ID: " + studentID + '\'' +
                "Course ID: " + courseID + '\'' +
                "Grade ID: " + gradeID + '\n' +
                "Grade Earned: " + gradeEarned;
    }
}
