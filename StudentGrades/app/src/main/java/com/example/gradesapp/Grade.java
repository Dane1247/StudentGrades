package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADE_TABLE)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int gradeID;
    String score,dateEarned;
    int assignmentID,studentID,courseID;

    public Grade(String score, String dateEarned, int assignmentID, int studentID, int courseID) {
        this.score = score;
        this.dateEarned = dateEarned;
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public Grade() {
        this.score = "";
        this.assignmentID = -1;
        this.studentID = -1;
        this.courseID = -1;
        this.dateEarned = "";
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
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
                "Assignment ID: " + assignmentID + '\n' +
                "Student ID: " + studentID + '\n' +
                "Course ID: " + courseID + '\n' +
                "Score: " + score + '\n' +
                "Date Earned: " + dateEarned;
    }
    //
}