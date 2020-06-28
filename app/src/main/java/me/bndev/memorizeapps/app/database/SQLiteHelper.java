package me.bndev.memorizeapps.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import me.bndev.memorizeapps.app.config.DBConfig;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLiteHelper";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DBConfig.DB_NAME, null, DBConfig.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            DBConfig.createDatabase(db);
        } catch (SQLiteException e) {
            Log.e(TAG, "onCreate: ", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            DBConfig.versionUpgrade(db, oldVersion, newVersion);
        } catch (SQLiteException e) {
            Log.e(TAG, "onUpgrade: ", e);
        }
    }

}
