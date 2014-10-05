package com.example.imageswitcher_01;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements View.OnClickListener,ViewSwitcher.ViewFactory{
    private ImageSwitcher imageSwitcher;
    private Button preBtn,nextBtn;
    private int index = 0;
    private List<Drawable> list = new ArrayList<Drawable>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitch);
        preBtn = (Button)findViewById(R.id.preview);
        nextBtn = (Button)findViewById(R.id.next);

        preBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        imageSwitcher.setFactory(this);

        list.add(getResources().getDrawable(R.drawable.image1));
        list.add(getResources().getDrawable(R.drawable.image2));
        list.add(getResources().getDrawable(R.drawable.image3));
        list.add(getResources().getDrawable(R.drawable.image4));
        list.add(getResources().getDrawable(R.drawable.image5));
        list.add(getResources().getDrawable(R.drawable.image6));

        if(list.size() > 0) {
            imageSwitcher.setImageDrawable(list.get(0));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.preview:
                index --;
                if(index<=0) {
                    index = list.size() -1;
                }
                imageSwitcher.setImageDrawable(list.get(index));
                break;
            case R.id.next:
                index ++;
                if(index >= list.size()) {
                    index = 0;
                }
                imageSwitcher.setImageDrawable(list.get(index));
                break;
            default:
                break;

        }

    }

    @Override
    public View makeView() {
        return new ImageView(MyActivity.this);
    }
}
