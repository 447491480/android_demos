package com.example.seekbar_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MyActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    private TextView textView1;
    private TextView textView2;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview2);

        SeekBar seekBar1 =  (SeekBar)findViewById(R.id.seekbar);
        SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekbar2);

        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        if(seekBar.getId() == R.id.seekbar) {
            textView1.setText("seekbar 1 value:" + i);
        } else {
            textView2.setText("seekbar 2 value:"  + i);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId() == R.id.seekbar) {
            textView1.setText("seekbar 1 start");
        } else {
            textView2.setText("seekbar 2 start");
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId() == R.id.seekbar) {
            textView1.setText("seekbar 1 stop");
        } else {
            textView2.setText("seekbar 2 stop");
        }
    }
}
