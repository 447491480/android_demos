package com.example.contentprovider_01;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import java.util.Locale;

/**
 * Created by chang on 14-10-10.
 */
public class StudentProvider extends ContentProvider {
    private final String TAG = "StudentProvider";

    private DBHelper helper = null;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int STUDENT = 1;
    private static final int SUTDENTS = 2;
    static {
        URI_MATCHER.addURI("com.example.contentprovider_01.StudentProvider","student/#",STUDENT);
        URI_MATCHER.addURI("com.example.contentprovider_01.StudentProvider","student",SUTDENTS);
    }

    @Override
    public boolean onCreate() {
        helper = new DBHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        int flag = URI_MATCHER.match(uri);

        switch (flag) {
            case STUDENT:
                return "vnd.android.cursor.item/student";
            case SUTDENTS:
                return "vnd.android.cursor.item/students";
        }

        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri retUri = null;

        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case SUTDENTS:
                SQLiteDatabase database = helper.getWritableDatabase();
                long id = database.insert("student",null,contentValues);
                retUri = ContentUris.withAppendedId(uri,id);

                break;
            case STUDENT:
                break;
        }

        Log.i(TAG,"-->"+retUri.toString());
        return retUri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
