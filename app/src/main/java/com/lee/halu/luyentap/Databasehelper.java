package com.lee.halu.luyentap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    public Databasehelper(@Nullable Context context) {
        super(context, "sss", null, 1);
    }

    public static final String TABLE_NAME = "tablename";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " VARCHAR(5), "
            + NAME + " VARCHAR(20), "
            + PRICE + " INTEGER ) ";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
