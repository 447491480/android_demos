package com.example.edittext_01;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.util.Random;

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

        et = (EditText)findViewById(R.id.edittext);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomId = 1 + new Random().nextInt(3);

                try{
                    Field field = R.drawable.class.getDeclaredField("image"+randomId);
                    int resId = Integer.parseInt(field.get(null).toString());
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resId);

                    ImageSpan imageSpan = new ImageSpan(MyActivity.this,bitmap);
                    SpannableString spannableString = new SpannableString("image");
                    spannableString.setSpan(imageSpan,0,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    et.append(spannableString);

                }catch (Exception e) {

                }


            }
        });
    }
}
