package com.example.sharepreferences_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Map;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        MySharedRef mySharedRef = new MySharedRef(this);
        mySharedRef.saveMessage("Hello","111111");
        Map<String,Object> retMap = mySharedRef.getMessage();

        Toast.makeText(this,retMap.get("name").toString(),Toast.LENGTH_SHORT).show();
    }
}
