package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.GradeCategory;

import java.util.List;

@Dao
public interface GradeCategoryDAO {
    @Insert
    void insert(GradeCategory... users);

    @Update
    void update(GradeCategory... users);

    @Delete
    void delete(GradeCategory... users);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " ORDER BY username")
    List<GradeCategory> getUsers();

    @Query("DELETE FROM " + AppDatabase.USER_TABLE)
    void nukeTable();
}