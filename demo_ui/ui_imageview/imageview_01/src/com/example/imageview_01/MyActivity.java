package com.example.imageview_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView imageView1 = (ImageView)findViewById(R.id.imageview1);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageview2);

        //imageView1.setLayoutParams(new LinearLayout.LayoutParams(200,100));
        //setTitle("height:"+imageView1.getLayoutParams().height+",width:"+imageView1.getLayoutParams().width);
    }
}
