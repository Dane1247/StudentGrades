package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADE_TABLE)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int key;

    String score,assighnmentID,studentID,courseID,dateEarned,gradeID;

    public Grade(String score, String assighnmentID, String studentID, String courseID, String dateEarned, String gradeID) {
        this.score = score;
        this.assighnmentID = assighnmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.dateEarned = dateEarned;
        this.gradeID = gradeID;
<<<<<<< HEAD
    }

    public int getKey() {
        return key;
    }

=======
    }

    public Grade() {
        this.score = "";
        this.assighnmentID = "";
        this.studentID = "";
        this.courseID = "";
        this.dateEarned = "";
        this.gradeID = "";
    }

    public int getKey() {
        return key;
    }

>>>>>>> parent of a244bd5... made initial database changes
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
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }
<<<<<<< HEAD
=======

    @Override
    public String toString() {
        return  "Assighnment ID: " + assighnmentID + '\n' +
                "Student ID: " + studentID + '\n' +
                "Course ID: " + courseID + '\n' +
                "Grade ID: " + gradeID + '\n' +
                "Score: " + score + '\n' +
                "Date Earned: " + dateEarned;
    }
>>>>>>> parent of a244bd5... made initial database changes
}
