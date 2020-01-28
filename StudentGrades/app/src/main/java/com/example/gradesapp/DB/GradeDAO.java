package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.Grade;

import java.util.List;

@Dao
public interface GradeDAO {
    @Insert
    void insert(Grade... users);

    @Update
    void update(Grade... users);

    @Delete
    void delete(Grade... users);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " ORDER BY username")
    List<Grade> getUsers();

    @Query("DELETE FROM " + AppDatabase.USER_TABLE)
    void nukeTable();
}