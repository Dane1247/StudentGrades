package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGHNMENT_TABLE)
public class Assighnment {
    @PrimaryKey(autoGenerate = true)
    private int key;
    String details,assighnedDate,dueDate,categoryID,courseID,assighnmentID;
    Float earnedScore,maxScore;

    public Assighnment(String details, String assighnedDate, String dueDate, String categoryID, String courseID, String assighnmentID, Float earnedScore, Float maxScore) {
        this.details = details;
        this.assighnedDate = assighnedDate;
        this.dueDate = dueDate;
        this.categoryID = categoryID;
        this.courseID = courseID;
        this.assighnmentID = assighnmentID;
        this.earnedScore = earnedScore;
        this.maxScore = maxScore;
    }

    public Assighnment() {
        this.details = "";
        this.assighnedDate = "";
        this.dueDate = "";
        this.categoryID = "";
        this.courseID = "";
        this.assighnmentID = "";
        this.earnedScore = 1f;
        this.maxScore = 1f;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAssighnedDate() {
        return assighnedDate;
    }

    public void setAssighnedDate(String assighnedDate) {
        this.assighnedDate = assighnedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getAssighnmentID() {
        return assighnmentID;
    }

    public void setAssighnmentID(String assighnmentID) {
        this.assighnmentID = assighnmentID;
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
        return "Assighnment ID: " + assighnmentID + '\n' +
                "CategoryID: " + categoryID + '\n' +
                "CourseID: " + courseID + '\n' +
                "Details" + details + '\n' +
                "Assighned Date: " + assighnedDate + '\n' +
                "Due Date" + dueDate + '\n' +
                "Earned Score:" + earnedScore + '\n'+
                "Max Score: " + maxScore;
    }
}
