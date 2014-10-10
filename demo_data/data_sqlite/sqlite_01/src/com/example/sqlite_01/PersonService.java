package com.example.sqlite_01;

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

    @Override
    public boolean addPerson(Object[] params) {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;

        try {
            String sql = "insert into person(name,address,sex)values(?,?,?)";
            sqLiteDatabase = helper.getWritableDatabase();
            sqLiteDatabase.execSQL(sql,params);
            flag = true;
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
    public boolean deletePerson(Object[] params) {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;

        try {
            String sql = "delete from person where id = ?";
            sqLiteDatabase = helper.getWritableDatabase();
            sqLiteDatabase.execSQL(sql,params);
            flag = true;
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
    public boolean updatePerson(Object[] params) {
        boolean flag = false;

        SQLiteDatabase sqLiteDatabase = null;

        try {
            String sql = "update person set name=?,address=?,sex=? where id=?";
            sqLiteDatabase = helper.getWritableDatabase();
            sqLiteDatabase.execSQL(sql,params);
            flag = true;
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
    public Map<String, String> viewPerson(String[] selectionArgs) {
        Map<String,String> map = new HashMap<String, String>();
        SQLiteDatabase sqLiteDatabase = null;

        try{
            String sql="select * from person where id=?";
            sqLiteDatabase = helper.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(sql,selectionArgs);
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
    public List<Map<String, String>> listPersonMaps(String[] selectionArgs) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        String sql = "select * from persion";
        SQLiteDatabase sqLiteDatabase = null;

        try {
            sqLiteDatabase = helper.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(sql,selectionArgs);
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
