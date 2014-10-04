package com.example.radiobutton_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyActivity extends Activity {
    private RadioGroup rg;
    private Button btn;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        rg = (RadioGroup)findViewById(R.id.rg);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int len = rg.getChildCount();
                String msg = "";
                for(int i=0;i<len;i++) {
                    RadioButton rb = (RadioButton)rg.getChildAt(i);
                    if(rb.isChecked()) {
                        msg = rb.getText().toString();
                        break;
                    }
                }

                Toast.makeText(MyActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
