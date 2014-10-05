package com.example.imageview_04;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MyActivity extends Activity {
    private Button downLoadBtn;
    private ImageView imageView;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        downLoadBtn = (Button)findViewById(R.id.btn);
        imageView = (ImageView)findViewById(R.id.imageView);

        downLoadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    InputStream inputStream = HttpUtil.getImageViewInputStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);

                }catch (IOException e) {

                }

            }
        });
    }
}
