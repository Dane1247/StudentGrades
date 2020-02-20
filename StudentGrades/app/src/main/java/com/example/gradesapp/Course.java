package com.example.gradesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradesapp.DB.AppDatabase;
import com.example.gradesapp.DB.CourseDAO;

@Entity(tableName = AppDatabase.COURSE_TABLE)
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;
    String instructor,title,description,startDate,endDate;

    public Course(String instructor, String title, String description, String startDate, String endDate) {
        this.instructor = instructor;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Course(String courseInstructor, String courseTitle, String courseDescription, String courseStart, String courseEnd, CourseDAO courseDAO) {
        this.instructor = "";
        this.title = "";
        this.description = "";
        this.startDate = "";
        this.endDate = "";
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + "\n" +
                "Instructor: " + instructor + '\n' +
                "Title: " + title + '\n' +
                "Description: " + description + '\n' +
                "Start Date: " + startDate + '\n' +
                "End Date: " + endDate;
    }
    //
}
