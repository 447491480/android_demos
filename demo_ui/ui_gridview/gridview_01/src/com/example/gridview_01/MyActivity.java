package com.example.gridview_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyActivity extends Activity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    private ImageView imageView;
    private int[] resdis = new int[] {
            R.drawable.image1,R.drawable.image2,R.drawable.image3,
            R.drawable.image4,R.drawable.image5,R.drawable.image6,
            R.drawable.image7,R.drawable.image8,R.drawable.image9
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        imageView = (ImageView)findViewById(R.id.imageView);

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0; i<resdis.length;i++) {

            Map<String,Object> cell = new HashMap<String, Object>();
            cell.put("imageview",resdis[i]);
            list.add(cell);

        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(MyActivity.this,list,R.layout.cell,new String[]{"imageview"},new int[]{R.id.imageView2});
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemSelectedListener(this);
        gridView.setOnItemClickListener(this);
        imageView.setImageResource(resdis[0]);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        imageView.setImageResource(resdis[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("index:" + i);
        imageView.setImageResource(resdis[i]);
    }
}
