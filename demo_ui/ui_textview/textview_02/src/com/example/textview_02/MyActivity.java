package com.example.textview_02;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MyActivity extends Activity {

    public int getResourcesId(String name) {
        try {

            Field field = R.drawable.class.getField(name);
            return Integer.parseInt(field.get(null).toString());

        } catch (Exception e) {

        }
        return 0;
    }


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.WHITE);
        textView.setTextSize(20);

        String html = "图像1<img src='image1'></img>图像2<img src='image2'></img>图像3<img src='image3'></img>图像4<a href='http://www.baidu.com'><img src='image4'></img></a>图像5<img src='image5'></img>";

        CharSequence charSequence = Html.fromHtml(html,new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String s) {
                Drawable drawable = getResources().getDrawable(getResourcesId(s));

                if(s.equals("image3")) {
                    drawable.setBounds(0,0,drawable.getIntrinsicWidth()/4,drawable.getIntrinsicHeight()/4);
                } else {
                    drawable.setBounds(0,0,drawable.getIntrinsicWidth()/2,drawable.getIntrinsicHeight()/2);
                }

                return drawable;
            }
        },null);

        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
