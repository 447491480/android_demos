package com.example.edittext_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
    private EditText et;
    private Button btn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et = (EditText)findViewById(R.id.num);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = et.getText().toString();
                System.out.println(val);
                if(val==null || val.trim().equals("")) {
                    et.setError("不能为空！");
                    return;
                }
            }
        });
    }
}
