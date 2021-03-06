package com.example.android.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "Database";
    static int version = 1;

    String createTableUser = "CREATE TABLE if not exists \"user\" (\n" +
            "\t\"id\"\tINTEGER,\n" +
            "\t\"username\"\tTEXT,\n" +
            "\t\"password\"\tTEXT,\n" +
            "\t\"email\"\tTEXT,\n" +
            "\t\"DOB\"\tTEXT,\n" +
            "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
            ")";


    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void insertUser(ContentValues contentValues) {
        getWritableDatabase().insert( "user","", contentValues );
    }

    public boolean isLoginValid(String username, String password){
        String sql = "Select count * from user where username '" +username+"' and password '" +password+"' ";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        statement.close();

        if(l == 1){
            return true;
        } else {
            return false;
        }
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
