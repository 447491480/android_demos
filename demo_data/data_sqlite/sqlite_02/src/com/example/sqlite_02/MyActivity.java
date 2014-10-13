package com.example.sqlite_02;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

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
                textView.setText(Boolean.toString(new PersonService(getApplicationContext()).addPerson()));
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Boolean.toString(new PersonService(getApplicationContext()).deletePerson("id=?",new String[]{"4"})));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("name","jacy");
                values.put("address","yyy");
                textView.setText(Boolean.toString(new PersonService(getApplicationContext()).updatePerson(values,"id=?", new String[]{"4"})));
            }
        });

        queryPersonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new PersonService(getApplicationContext()).viewPerson("id=?",new String[]{"2"});
                System.out.println(map.toString());
            }
        });

        queryPersonsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Map<String,String>> list =  new PersonService(getApplicationContext()).listPersonMaps(null,null);
                System.out.println(list.toString());
            }
        });
    }
}
