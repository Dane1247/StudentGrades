package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADECATEGORY_TABLE)
public class GradeCategory {
    @PrimaryKey(autoGenerate = true)
    private int key;

    String title,gradeID,assighnedDate,categoryID;
    Float weight;

<<<<<<< HEAD
    public GradeCategory(String title, String gradeID, String assighnedDate, String categoryID, Float weight) {
        this.title = title;
        this.gradeID = gradeID;
        this.assighnedDate = assighnedDate;
        this.categoryID = categoryID;
        this.weight = weight;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
=======
    public GradeCategory() {
        this.title = "";
        this.gradeID = "";
        this.assighnedDate = "";
        this.categoryID = "";
        this.weight = 1f;
>>>>>>> parent of a244bd5... made initial database changes
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public String getAssighnedDate() {
        return assighnedDate;
    }

    public void setAssighnedDate(String assighnedDate) {
        this.assighnedDate = assighnedDate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
<<<<<<< HEAD
=======

    @Override
    public String toString() {
        return "Title: " + title + '\n' +
                "Grade ID: " + gradeID + '\n' +
                "AssighnedDate: " + assighnedDate + '\n' +
                "Category ID: " + categoryID + '\n' +
                "Weight: " + weight;
    }
>>>>>>> parent of a244bd5... made initial database changes
}