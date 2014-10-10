package com.example.sqlite_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chang on 14-10-9.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static String name = "mydb.db";

    private static int version = 3;

    public SQLiteHelper(Context context) {
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        String sql = "alter table person add sex varchar(8)";
        sqLiteDatabase.execSQL(sql);
    }
}
