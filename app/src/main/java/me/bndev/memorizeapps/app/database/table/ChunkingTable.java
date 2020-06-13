package me.bndev.memorizeapps.app.database.table;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import me.bndev.memorizeapps.app.config.Tags;

public class ChunkingTable {
    private static final String TAG = "ChunkingTable";

    public static final String tableName = "tbl_chunking";

    public static final String colID                    = "_id";
    public static final String colGenerateObject        = "generate_object";
    public static final String colInputObject           = "input_object";
    public static final String colChunkingType          = "chunking_type";
    public static final String colPercentageOfCorrect   = "percentage_of_correct";
    public static final String colTimeToRemember        = "time_to_remember";
    public static final String colLevel                 = "level";
    public static final String colNumberOfObject        = "number_of_object";

    public static final String[] fields = new String[]{
            colID,
            colGenerateObject,
            colInputObject,
            colChunkingType,
            colPercentageOfCorrect,
            colTimeToRemember,
            colLevel,
            colNumberOfObject
    };

    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                colID + " INT PRIMARY KEY AUTOINCREMENT," +
                colGenerateObject + " TEXT, " +
                colInputObject + " TEXT, " +
                colChunkingType + " TEXT, " +
                colPercentageOfCorrect + " TEXT, " +
                colTimeToRemember + " TEXT, " + // HH:mm:ss
                colLevel + " TEXT, " +
                colNumberOfObject + " TEXT" + // depending level
                ")");

        Log.i(Tags.LOG, "Table chunking has created");
    }

}
