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

    @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE)
    List<Grade> getGrades();

    @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE studentID = :inputStudentID")
    List<Grade> getGradeWithStudentID(int inputStudentID);

    @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE assignmentID = :inputAssignmentID")
    List<Grade> getGradeWithAssignmentID(int inputAssignmentID);

    @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE courseID = :inputCourseID")
    List<Grade> getGradeWithCourseID(int inputCourseID);

    @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE gradeID = :inputGradeID")
    List<Grade> getGradeWithGradeID(int inputGradeID);

    @Query("DELETE FROM " + AppDatabase.GRADE_TABLE)
    void nukeTable();
}