package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.Assighnment;

import java.util.List;

@Dao
public interface AssighnmentDAO {
    @Insert
    void insert(Assighnment... users);

    @Update
    void update(Assighnment... users);

    @Delete
    void delete(Assighnment... users);

    //categoryID,courseID,assighnmentID;

    @Query("SELECT * FROM " + AppDatabase.ASSIGHNMENT_TABLE)
    List<Assighnment> getAssighnments();

    @Query("SELECT * FROM " + AppDatabase.ASSIGHNMENT_TABLE + " WHERE assighnmentID = :inputAssighnmentID")
    List<Assighnment> getAssighnmentsWithAssighnmentID(String inputAssighnmentID);

    @Query("SELECT * FROM " + AppDatabase.ASSIGHNMENT_TABLE + " WHERE courseID = :inputCourseID")
    List<Assighnment> getAssighnmentsWithCourseID(String inputCourseID);

    @Query("SELECT * FROM " + AppDatabase.ASSIGHNMENT_TABLE + " WHERE categoryID = :inputCategoryID")
    List<Assighnment> getAssighnmentsWithCategoryID(String inputCategoryID);

    @Query("DELETE FROM " + AppDatabase.ASSIGHNMENT_TABLE)
    void nukeTable();
}