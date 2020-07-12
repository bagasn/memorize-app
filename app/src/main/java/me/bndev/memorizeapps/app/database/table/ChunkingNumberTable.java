package me.bndev.memorizeapps.app.database.table;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import me.bndev.memorizeapps.app.config.Tags;

public class ChunkingNumberTable {
    private static final String TAG = "ChunkingTable";

    public static final String tableName = "t_chunking_number";

    public static final String colID                    = "_id";
    public static final String colGenerateObject        = "generate_object";
    public static final String colInputObject           = "input_object";
    public static final String colPercentageOfCorrect   = "percentage_of_correct";
    public static final String colTimeToRemember        = "time_to_remember";
    public static final String colLevel                 = "level";
    public static final String colNumberOfObject        = "number_of_object";
    public static final String colNumberOfChunk         = "number_of_chunk";
    public static final String colInputBy               = "input_by";
    public static final String colStatus                = "status";

    public static final String[] fields = new String[]{
            colID,
            colGenerateObject,
            colInputObject,
            colPercentageOfCorrect,
            colTimeToRemember,
            colLevel,
            colNumberOfObject,
            colNumberOfChunk,
            colInputBy,
            colStatus
    };

    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                colID + " INT PRIMARY KEY AUTOINCREMENT," +
                colGenerateObject + " TEXT, " +
                colInputObject + " TEXT, " +
                colPercentageOfCorrect + " TEXT, " +
                colTimeToRemember + " TEXT, " + // HH:mm:ss
                colLevel + " TEXT, " +
                colNumberOfObject + " TEXT, " + // depending level
                colNumberOfChunk + " TEXT, " + // depending level
                colInputBy + " TEXT, " + // depending level
                colStatus + " TEXT" + // depending level
                ")");

        Log.i(Tags.LOG, "Table chunking has created");
    }

}
