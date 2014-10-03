package com.example.button_02;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.Button;

public class MyActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.button);

        SpannableString spannableString = new SpannableString("left");
        Bitmap bitmapLeft = BitmapFactory.decodeResource(getResources(),R.drawable.image1);
        ImageSpan imageSpanLeft = new ImageSpan(bitmapLeft, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableString.setSpan(imageSpanLeft,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableStringRight = new SpannableString("right");
        Bitmap bitmapRight = BitmapFactory.decodeResource(getResources(),R.drawable.image2);
        ImageSpan imageSpanRight = new ImageSpan(bitmapRight);
        spannableStringRight.setSpan(imageSpanRight,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        btn.append(spannableString);
        btn.append("我的按钮");
        btn.append(spannableStringRight);
    }
}
