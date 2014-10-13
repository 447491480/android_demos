package com.example.sqlite_02;

import android.content.ContentValues;

import java.util.List;
import java.util.Map;

/**
 * Created by chang on 14-10-10.
 */
public interface IPersionService {
    public boolean addPerson();

    public boolean deletePerson(String whereClause,String[] whereArgs);

    public boolean updatePerson(ContentValues values,String whereClause,String[] whereArgs);

    public Map<String,String> viewPerson(String selection,String[] selectionArgs);

    public List<Map<String,String>> listPersonMaps(String selection,String[] selectionArgs);
}
