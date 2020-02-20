package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    private int assignmentID;

    String details,assignedDate,dueDate;
    int categoryID,courseID;
    Float earnedScore,maxScore;

    public Assignment(
            String details,
            String assignedDate,
            String dueDate,
            int categoryID,
            int courseID,
            Float earnedScore,
            Float maxScore
    ){
        this.details = details;
        this.assignedDate = assignedDate;
        this.dueDate = dueDate;
        this.categoryID = categoryID;
        this.courseID = courseID;
        this.earnedScore = earnedScore;
        this.maxScore = maxScore;
    }

    public Assignment() {
        this.details = "";
        this.assignedDate = "";
        this.dueDate = "";
        this.categoryID = -1;
        this.courseID = -1;
        this.earnedScore = 1f;
        this.maxScore = 1f;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public Float getEarnedScore() {
        return earnedScore;
    }

    public void setEarnedScore(Float earnedScore) {
        this.earnedScore = earnedScore;
    }

    public Float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Float maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Assignment ID: " + assignmentID + '\n' +
                "CategoryID: " + categoryID + '\n' +
                "CourseID: " + courseID + '\n' +
                "Details: " + details + '\n' +
                "Assigned Date: " + assignedDate + '\n' +
                "Due Date: " + dueDate + '\n' +
                "Earned Score: " + earnedScore + '\n'+
                "Max Score: " + maxScore;
    }
    //
}