package com.example.contentprovider_01;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView textView;
    private Button insertBtn;
    private Button deleteBtn;
    private Button updateBtn;
    private Button queryPersonBtn;
    private Button queryPersonsBtn;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView =  (TextView)findViewById(R.id.textView);
        insertBtn = (Button)findViewById(R.id.insertBtn);
        deleteBtn = (Button)findViewById(R.id.deleteBtn);
        updateBtn = (Button)findViewById(R.id.updateBtn);
        queryPersonBtn = (Button)findViewById(R.id.queryPersonBtn);
        queryPersonsBtn = (Button)findViewById(R.id.queryPersonsBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student");
                ContentValues contentValues = new ContentValues();

                contentValues.put("name","Jack");
                contentValues.put("age","12");

                contentResolver.insert(uri,contentValues);
                System.out.println(uri.toString());
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student/1");
                int i = contentResolver.delete(uri,null,null);
                System.out.println(Integer.toString(i));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student/2");
                ContentValues values = new ContentValues();
                values.put("name","lisi");
                values.put("address","hefei");
                contentResolver.update(uri,values,null,null);
            }
        });

        queryPersonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student/2");
                Cursor cursor = contentResolver.query(uri,null,null,null,null);

                while(cursor.moveToNext()) {
                    System.out.println("-->"+cursor.getString(cursor.getColumnIndex("name")));
                }
            }
        });

        queryPersonsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.example.contentprovider_01.StudentProvider/student");
                Cursor cursor = contentResolver.query(uri,null,null,null,null);

                while(cursor.moveToNext()) {
                    System.out.println("-->"+cursor.getString(cursor.getColumnIndex("name")));
                }
            }
        });



    }
}
