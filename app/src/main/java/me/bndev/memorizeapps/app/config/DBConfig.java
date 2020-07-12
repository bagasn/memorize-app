package me.bndev.memorizeapps.app.config;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import me.bndev.memorizeapps.app.database.table.ChunkingNumberTable;

public class DBConfig {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "memorizeapps.db";

    public static void createDatabase(SQLiteDatabase database) throws SQLiteException {
        ChunkingNumberTable.createTable(database);
    }

    public static void versionUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLiteException {
        for (int version = oldVersion + 1; version <= newVersion; version++) {
            // TODO: 05/07/20 upgrade or downgrade table version
        }
    }

}
