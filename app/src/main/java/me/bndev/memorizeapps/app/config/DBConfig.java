package me.bndev.memorizeapps.app.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import me.bndev.memorizeapps.app.database.SQLiteHelper;
import me.bndev.memorizeapps.app.database.table.ChunkingTable;

public class DBConfig {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "memorizeapps.db";

    public static void createDatabase(SQLiteDatabase database) throws SQLiteException {
        ChunkingTable.createTable(database);
    }

    public static void versionUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLiteException {
        for (int i = oldVersion + 1; i <= newVersion; i++) {
            // TODO: 05/06/20 : database updgrade
        }
    }

}
