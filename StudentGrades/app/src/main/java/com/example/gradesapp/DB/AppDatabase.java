package com.example.gradesapp.DB;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;

import com.example.gradesapp.User;

@Database(entities = {User.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String dbName="db-flightInfo";
    public static final String TRANSACTION_TABLE="transactions";
    public static final String RESERVATION_TABLE="reservations";
    public static final String FLIGHT_TABLE="flights";
    public static final String USER_TABLE="users";
    public abstract UserDAO getUserDAO();
}