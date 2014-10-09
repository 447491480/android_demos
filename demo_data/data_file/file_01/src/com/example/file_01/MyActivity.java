package com.example.file_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView textView;
    private EditText editText;
    private Button saveBtn;
    private Button readBtn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        readBtn = (Button)findViewById(R.id.readBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyThread().start();


            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(FileService.readFileContent("hello.txt"));
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            boolean ret = FileService.saveToSdcard("hello.txt",editText.getText().toString());
            System.out.print(ret);
        }
    }
}
