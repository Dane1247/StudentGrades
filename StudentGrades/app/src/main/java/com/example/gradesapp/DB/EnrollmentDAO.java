package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.Enrollment;

import java.util.List;

@Dao
public interface EnrollmentDAO {
    @Insert
    void insert(Enrollment... users);

    @Update
    void update(Enrollment... users);

    @Delete
    void delete(Enrollment... users);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<Enrollment> getEnrollmentss();

    @Query("DELETE FROM " + AppDatabase.USER_TABLE)
    void nukeTable();
}