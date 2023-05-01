package com.example.irs_hard_drives.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HDDataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HardDiskDrive.bd";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "hard_disk";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COMPANY = "company";
    private static final String COLUMN_SIZE = "size";
    private static final String COLUMN_DESCRIPTION = "description";

    public HDDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + "TEXT, " +
                COLUMN_COMPANY + "TEXT, " +
                COLUMN_SIZE + "INTEGER, " +
                COLUMN_DESCRIPTION + "TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
