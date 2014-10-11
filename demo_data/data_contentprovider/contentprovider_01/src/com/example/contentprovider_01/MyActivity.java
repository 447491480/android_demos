package com.example.contentprovider_01;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student");
        ContentValues contentValues = new ContentValues();

        contentValues.put("name","Jack");
        contentValues.put("age","12");

        contentResolver.insert(uri,contentValues);
    }
}
