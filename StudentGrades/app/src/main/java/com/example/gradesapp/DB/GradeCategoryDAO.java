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

    @Query("SELECT * FROM " + AppDatabase.GRADECATEGORY_TABLE)
    List<GradeCategory> getGradeCategories();

    @Query("SELECT * FROM " + AppDatabase.GRADECATEGORY_TABLE + " WHERE gradeID = :inputGradeID")
    List<GradeCategory> getGradeCategoryWithGradeID(int inputGradeID);

    @Query("SELECT * FROM " + AppDatabase.GRADECATEGORY_TABLE + " WHERE categoryID = :inputCategoryID")
    List<GradeCategory> getGradeCategoryWithCategoryID(int inputCategoryID);


    @Query("DELETE FROM " + AppDatabase.GRADECATEGORY_TABLE)
    void nukeTable();
}