package com.example.checkbox_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements View.OnClickListener{
    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        String[] checkBoxText = new String[]{
            "are you student?","are you love android?","are you dev?"
        };

        LinearLayout linearLayout = (LinearLayout)getLayoutInflater().inflate(R.layout.main,null);

        for(int i=0;i<checkBoxText.length;i++) {
            CheckBox checkBox = (CheckBox)getLayoutInflater().inflate(R.layout.checkbox,null);
            checkBox.setText(checkBoxText[i]);

            checkBoxes.add(checkBox);
            linearLayout.addView(checkBox,i);
        }

        setContentView(linearLayout);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String s = "";
        for(CheckBox cb : checkBoxes) {
            if(cb.isChecked()) {
                s+=cb.getText() + "\n";
            }
        }

        if("".equals(s)) {
            s = "你没有选择选项";
        }

        new AlertDialog.Builder(this).setMessage(s).setPositiveButton("关闭",null).show();
    }
}
