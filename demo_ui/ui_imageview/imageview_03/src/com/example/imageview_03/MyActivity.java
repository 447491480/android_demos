package com.example.imageview_03;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MyActivity extends Activity implements SeekBar.OnSeekBarChangeListener{
    private int minWidth = 80;
    private ImageView imageView;
    private TextView textView1,textView2;
    private Matrix matrix = new Matrix();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageView = (ImageView)findViewById(R.id.imageView);
        SeekBar seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        seekBar1.setMax(dm.widthPixels-minWidth);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.seekBar1) {
            int newWidth = i + minWidth;
            int newHeight = (int)(newWidth*3/4);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newHeight));
            textView1.setText("图像宽度："+newWidth+"，图像高度：" + newHeight);
        } else if (seekBar.getId() == R.id.seekBar2) {
            Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.image1))).getBitmap();
            matrix.setRotate(i);
            bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
            imageView.setImageBitmap(bitmap);
            textView2.setText(i+"度");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
