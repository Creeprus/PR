package com.example.splashscreensqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context)
    {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//Создание таблицы
        sqLiteDatabase.execSQL("create Table UserInfo(login TEXT primary key," + "password TEXT, role TEXT)");
        sqLiteDatabase.execSQL("create Table NewsFeed(title TEXT primary key," + "content TEXT)");

      //  sqLiteDatabase.execSQL("insert into NewsFeed (login,password,role) values (UltraPepega,OofMega20000,Admin)");
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("login", "UltraPepega");
//        contentValues.put("password", "OofMega20000");
//        contentValues.put("role","Admin");
//
//        DB.insert("UserInfo", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int
            oldVersion, int newVersion) {
//Условие на удаление таблицы
        sqLiteDatabase.execSQL("drop Table if exists UserInfo");
        sqLiteDatabase.execSQL("drop Table if exists NewsFeed");
    }

    public Boolean Insert_User(String login, String password, String
            role) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", login);
        contentValues.put("password", password);
        contentValues.put("role", role);
        long result = DB.insert("UserInfo", null, contentValues);
        return result != -1;
    }
    public Boolean Insert_News(String title,String content)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        long result = DB.insert("NewsFeed", null, contentValues);
        return result != -1;
    }
    public Boolean Update_News(String title,String content)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        long result = DB.update("NewsFeed", contentValues, "title=?", new
             String[]{title});
        return result != -1;
    }
    public Boolean Delete_News(String title)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        long result = DB.delete("NewsFeed", "title=?", new
               String[]{title});
        return result != -1;
    }
    public Cursor Select_Role(String login, String password)
    {
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String[] Col=new String[]{login,password};
        return sqLiteDatabase.rawQuery("Select role from UserInfo where login=? and password=?",Col);
    }
    public Cursor GetNews ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("Select * from NewsFeed", null);
    }
    public Cursor getData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("Select * from UserInfo", null);
    }
}

//    public Boolean Update_User(String login, String password) {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("login", login);
//        contentValues.put("password", password);
//        long result = DB.update("UserInfo", contentValues, "login=?", new
//                String[]{login});
//        return result != -1;
//    }
//
//    public Boolean Delete_User(String login) {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("login", login);
//        long result = DB.delete("UserInfo", "login=?", new
//                String[]{login});
//        return result != -1;
//    }
//


