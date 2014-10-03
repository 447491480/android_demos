package com.example.button_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener,
        View.OnTouchListener,View.OnFocusChangeListener,View.OnKeyListener {

    private int val = 1;
    private Button commBtn;
    private Button imageBtn;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        commBtn = (Button)findViewById(R.id.comBtn);
        imageBtn = (Button)findViewById(R.id.imgBtn);

        commBtn.setOnClickListener(this);
        imageBtn.setOnClickListener(this);
        imageBtn.setOnTouchListener(this);
        imageBtn.setOnFocusChangeListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
            view.setBackgroundResource(R.drawable.image1);
        } else if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            view.setBackgroundResource(R.drawable.image2);
        }

        return false;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b) {
            imageBtn.setBackgroundResource(R.drawable.image1);
        } else {
            imageBtn.setBackgroundResource(R.drawable.image2);
        }

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(KeyEvent.ACTION_DOWN == keyEvent.getAction()) {
            view.setBackgroundResource(R.drawable.image1);
        } else if(keyEvent.ACTION_UP == keyEvent.getAction()) {
            view.setBackgroundResource(R.drawable.image2);
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        Button button = (Button)view;
        if (val==1 && button.getWidth() == getWindowManager().getDefaultDisplay().getWidth()) {
            val = -1;
        } else if(val == -1 && button.getWidth() < 100) {
            val = 1;
        }

        button.setWidth(button.getWidth() + (int)(button.getWidth()*0.1*val));
        button.setHeight(button.getHeight() + (int)(button.getHeight()*0.1*val));
    }
}
