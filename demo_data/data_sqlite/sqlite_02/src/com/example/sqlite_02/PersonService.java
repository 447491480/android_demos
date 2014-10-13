package com.example.sqlite_02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chang on 14-10-10.
 */
public class PersonService implements IPersionService {
    private SQLiteHelper helper = null;

    public PersonService(Context context) {
        helper = new SQLiteHelper(context);
    }

    @Override
    public boolean addPerson() {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;
        long id = -1;

        try {
            sqLiteDatabase = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name","jack");
            values.put("address","xxx");

            id = sqLiteDatabase.insert("person",null,values);
            flag = id != -1;
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
        }
        return flag;
    }

    @Override
    public boolean deletePerson(String whereClause,String[] whereArgs) {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;
        long id = -1;

        try {
            sqLiteDatabase = helper.getWritableDatabase();
            id = sqLiteDatabase.delete("person",whereClause,whereArgs);
            flag = id != -1;
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

        }

        return flag;
    }

    @Override
    public boolean updatePerson(ContentValues values,String whereClause,String[] whereArgs) {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;
        long id = -1;

        try {
            sqLiteDatabase = helper.getWritableDatabase();
            id = sqLiteDatabase.update("person",values,whereClause,whereArgs);
            flag = id!=-1;
        }catch (Exception e) {
            e.printStackTrace();

        }finally {

            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

        }

        return flag;
    }

    @Override
    public Map<String, String> viewPerson(String selection,String[] selectionArgs) {
        Map<String,String> map = new HashMap<String, String>();
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        try{
            sqLiteDatabase = helper.getReadableDatabase();
            cursor = sqLiteDatabase.query(true,"person",null,selection,selectionArgs,null,null,null,null);
            int colums = cursor.getColumnCount();

            while (cursor.moveToNext()) {
                for(int i=0;i<colums;i++) {
                    String cols_name = cursor.getColumnName(i);
                    String cols_value = cursor.getString(cursor.getColumnIndex(cols_name));
                    if (cols_value == null) {
                        cols_value = "";
                    }

                    map.put(cols_name,cols_value);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {

            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

        }
        return map;
    }

    @Override
    public List<Map<String, String>> listPersonMaps(String selection,String[] selectionArgs) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        try {
            sqLiteDatabase = helper.getWritableDatabase();
            cursor = sqLiteDatabase.query(false,"person",null,selection,selectionArgs,null,null,null,null);
            int colums = cursor.getColumnCount();

            while (cursor.moveToNext()) {
                Map<String,String> map = new HashMap<String, String>();
                for(int i=0;i<colums;i++) {
                    String cols_name = cursor.getColumnName(i);
                    String cols_value = cursor.getString(cursor.getColumnIndex(cols_name));
                    if (cols_value == null) {
                        cols_value = "";
                    }

                    map.put(cols_name,cols_value);
                }
                list.add(map);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
        }

        return list;
    }
}
