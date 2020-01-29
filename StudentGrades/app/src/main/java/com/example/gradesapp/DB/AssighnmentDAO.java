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

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<Assighnment> getAssighnments();

    @Query("DELETE FROM " + AppDatabase.USER_TABLE)
    void nukeTable();
}