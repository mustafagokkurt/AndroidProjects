package com.example.a09_databaseopenhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TodoOperation {
    DatabaseOpenHelper dbOpenHelper;
    SQLiteDatabase database;


    public TodoOperation(Context context) {
        dbOpenHelper = new DatabaseOpenHelper(context, "TodoDB", null, 1);
    }

    void Open(){
        database = dbOpenHelper.getWritableDatabase();
    }

    void Close(){
        if(database != null && database.isOpen()){
            database.close();
        }
    }

    public void Ekle(Todo todo){

        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", todo.getTitle());
        contentValues.put("Detail", todo.getDetail());

        Open();
        database.insert("Todo", null, contentValues);
        Close();
    }

    public void Guncelle(Todo todo){

        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", todo.getTitle());
        contentValues.put("Detail", todo.getDetail());

        Open();
        database.update("Todo", contentValues, "Id=?", new String[]{String.valueOf(todo.Id)});
        Close();
    }

    public void Sil(int id){

        Open();
        database.delete("Todo", "Id=?", new String[]{String.valueOf(id)});
        Close();
    }

    Cursor TumunuGetir(){
        String sql = "SELECT * FROM Todo";

        return database.rawQuery(sql,null);

    }

    public ArrayList<Todo> TumTodoGetir(){
        ArrayList<Todo> list = new ArrayList<>();
        Open();
        Cursor c = TumunuGetir();

        if(c.moveToFirst()){
            Todo t;

            do {
                t = new Todo();
                t.setId(c.getInt(c.getColumnIndex("Id")));
                t.setTitle(c.getString(c.getColumnIndex("Title")));
                t.setTitle(c.getString(c.getColumnIndex("Detail")));

                list.add(t);
            }while (c.moveToNext());
        }

        Close();
        return  list;
    }
}

