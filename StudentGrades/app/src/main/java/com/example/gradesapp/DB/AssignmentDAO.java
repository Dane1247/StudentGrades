package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.Assignment;

import java.util.List;

@Dao
public interface AssignmentDAO {
    @Insert
    void insert(Assignment... users);

    @Update
    void update(Assignment... users);

    @Delete
    void delete(Assignment... users);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE)
    List<Assignment> getAssignments();

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE assignmentID = :inputAssignmentID")
    List<Assignment> getAssignmentsWithAssignmentID(int inputAssignmentID);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE courseID = :inputCourseID")
    List<Assignment> getAssignmentsWithCourseID(int inputCourseID);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE categoryID = :inputCategoryID")
    List<Assignment> getAssignmentsWithCategoryID(int inputCategoryID);

    @Query("DELETE FROM " + AppDatabase.ASSIGNMENT_TABLE)
    void nukeTable();
}