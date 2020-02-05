package com.example.gradesapp.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gradesapp.Assighnment;
import com.example.gradesapp.Course;
import com.example.gradesapp.Enrollment;
import com.example.gradesapp.Grade;
import com.example.gradesapp.GradeCategory;
import com.example.gradesapp.User;

@Database(entities = {Assighnment.class, Course.class, Enrollment.class, Grade.class, GradeCategory.class, User.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String dbName="db-class-info";
    public static final String ASSIGHNMENT_TABLE="assighnments";
    public static final String COURSE_TABLE="courses";
    public static final String ENROLLMENT_TABLE="enrollments";
    public static final String GRADE_TABLE="grades";
    public static final String GRADECATEGORY_TABLE="gradecategories";
    public static final String USER_TABLE="users";
    public abstract AssighnmentDAO getAssighnmentDAO();
    public abstract CourseDAO getCourseDAO();
    public abstract EnrollmentDAO getEnrollmentDAO();
    public abstract GradeCategoryDAO getGradeCategoryDAO();
    public abstract GradeDAO getGradeDAO();
    public abstract UserDAO getUserDAO();
}