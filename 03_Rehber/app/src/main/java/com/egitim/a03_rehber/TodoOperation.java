package com.egitim.a03_rehber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TodoOperation {
    DatabaseOpenHelper dbOpenHelper;
    SQLiteDatabase database;


    public TodoOperation(Context context) {
        //dbOpenHelper = new DatabaseOpenHelper(context, "TodoDB", null, 1);
        dbOpenHelper = new DatabaseOpenHelper(context, "Kisi", null, 1);
    }

    void Open(){
        database = dbOpenHelper.getWritableDatabase();
    }

    void Close(){
        if(database != null && database.isOpen()){
            database.close();
        }
    }

    public void Ekle(Kisi kisi){

        ContentValues contentValues = new ContentValues();
        contentValues.put("Ad", kisi.ad);
        contentValues.put("Soyad", kisi.soyad);

        Open();
        database.insert("Kisi", null, contentValues);
        Close();
    }

    public void Guncelle(Kisi kisi){

        ContentValues contentValues = new ContentValues();
        contentValues.put("Ad", kisi.ad);
        contentValues.put("Soyad", kisi.soyad);

        Open();
        database.update("Kisi", contentValues, "Id=?", new String[]{String.valueOf(kisi.Id)});
        Close();
    }

    public void Sil(int id){

        Open();
        database.delete("Kisi", "Id=?", new String[]{String.valueOf(id)});
        Close();
    }

    Cursor TumunuGetir(){
        String sql = "SELECT * FROM Kisi";

        return database.rawQuery(sql,null);

    }

    public ArrayList<Kisi> TumKisiGetir(){
        ArrayList<Kisi> list = new ArrayList<>();
        Open();
        Cursor c = TumunuGetir();

        if(c.moveToFirst()){
            Kisi t;

            do {
                t = new Kisi();
                t.Id = (c.getInt(c.getColumnIndex("Id")));
                t.setAd(c.getString(c.getColumnIndex("Ad")));
                t.setSoyad(c.getString(c.getColumnIndex("Soyad")));

                list.add(t);
            }while (c.moveToNext());
        }

        Close();
        return  list;
    }
}

