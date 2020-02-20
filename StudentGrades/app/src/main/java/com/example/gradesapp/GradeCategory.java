package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADECATEGORY_TABLE)
public class GradeCategory {
    @PrimaryKey(autoGenerate = true)
    private int categoryID;
    int gradeID;
    String title,assighnedDate;
    Float weight;

    public GradeCategory(String title, int gradeID, String assighnedDate, Float weight) {
        this.title = title;
        this.gradeID = gradeID;
        this.assighnedDate = assighnedDate;
        this.weight = weight;
    }

    public GradeCategory() {
        this.title = "";
        this.gradeID = -1;
        this.assighnedDate = "";
        this.weight = 1f;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public String getAssighnedDate() {
        return assighnedDate;
    }

    public void setAssighnedDate(String assighnedDate) {
        this.assighnedDate = assighnedDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Category ID: " + categoryID + '\n' +
                "Grade ID: " + gradeID + '\n' +
                "Title: " + title + '\n' +
                "AssighnedDate: " + assighnedDate + '\n' +
                "Weight: " + weight;
    }
    //
}