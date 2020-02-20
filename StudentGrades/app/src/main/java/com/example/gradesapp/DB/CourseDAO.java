package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course... users);

    @Update
    void update(Course... users);

    @Delete
    void delete(Course... users);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE)
    List<Course> getCourses();

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE courseID = :inputCourseID")
    List<Course> getCoursesWithCourseID(int inputCourseID);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE title = :title")
    List<Course> getCoursesWithTitle(String title);

    @Query("DELETE FROM " + AppDatabase.COURSE_TABLE)
    void nukeTable();
}