package com.lee.halu.luyentap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    SQLiteDatabase db;
    Databasehelper databasehelper;

    public Dao(Context context) {
        databasehelper = new Databasehelper(context);
        db = databasehelper.getWritableDatabase();
    }

    public List<Model> getModel(String sql) {
        List<Model> models = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(0));
                model.setName(cursor.getString(1));
                model.setPrice(cursor.getInt(2));
                models.add(model);
            }
            while (cursor.moveToNext());

        }
        return models;
    }

    public List<Model> getModelAll() {
        String sql = " SELECT * FROM " + Databasehelper.TABLE_NAME;
        return getModel(sql);
    }
public void deleteMolde(String id){
    db.delete(Databasehelper.TABLE_NAME,Databasehelper.ID+" =? ",new String[]{id});
    }
    public void insertModel(String id,String name,int price){
        ContentValues values=new ContentValues();
        values.put(Databasehelper.ID,id);
        values.put(Databasehelper.NAME,name);
        values.put(Databasehelper.PRICE,price);
        db.insert(Databasehelper.TABLE_NAME,null,values);
    }
    public void  updateModel(String id,String name,int price){
        ContentValues values=new ContentValues();
        values.put(Databasehelper.ID,id);
        values.put(Databasehelper.NAME,name);
        values.put(Databasehelper.PRICE,price);
        db.update(Databasehelper.TABLE_NAME,values,Databasehelper.ID+" =? ",new String[]{id});
    }
}
