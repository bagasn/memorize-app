package me.bndev.memorizeapps.app.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import androidx.annotation.NonNull;

import me.bndev.memorizeapps.app.config.Tags;
import me.bndev.memorizeapps.app.database.SQLiteHelper;

public class DatabaseManager {
    private static final String TAG = "DatabaseManager";

    private SQLiteHelper mHelper;
    private SQLiteDatabase mDatabase;

    DatabaseManager(@NonNull Context context) {
        mHelper = new SQLiteHelper(context);
    }

    public static DatabaseManager init(Context context) {
        return new DatabaseManager(context);
    }

    public long insert(String table, ContentValues contentValues) throws SQLiteException {
        mDatabase = mHelper.getWritableDatabase();

        long rowId = mDatabase.insert(table, null, contentValues);
        if (rowId == -1) {
            Log.e(Tags.ERROR, "Failed to insert row with value: \n" + contentValues,
                    new SQLiteException("Failed to insert a row"));
        }

        return rowId;
    }

    public void close() {
        if (mDatabase != null) {
            if (mDatabase.isOpen())
                mDatabase.close();
        }

        if (mHelper != null)
            mHelper.close();
    }

}
