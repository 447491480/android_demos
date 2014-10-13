package com.example.sqlite_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView textView;
    private Button insertBtn;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView =  (TextView)findViewById(R.id.textView);
        insertBtn = (Button)findViewById(R.id.insertBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                textView.setText(Boolean.toString(new PersonService(getApplicationContext()).addPerson()));
            }
        });
    }
}
