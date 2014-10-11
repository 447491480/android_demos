package com.example.contentprovider_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chang on 14-10-10.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static String name = "mydb.db";
    private static int version = 1;

    public DBHelper(Context context) {
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table student(id integer primary key autoincrement, name varchar(64),age varchar(3))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
