package me.bndev.memorizeapps.app.config;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBConfig {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "memorizeapp.db";

    public static void createDatabase(SQLiteDatabase database) throws SQLiteException {

    }

    public static void versionUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLiteException {

    }

}
