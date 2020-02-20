package com.example.gradesapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradesapp.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE studentID = :inputStudentID")
    List<User> getUserWithId(int inputStudentID);

    // Janelle
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE username = :username AND password= :password")
    User getUser(String username, String password);

    // Sean
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE username = :username")
    List<User> getUserFromUsername(String username);

    @Query("DELETE FROM " + AppDatabase.USER_TABLE)
    void nukeTable();
}