package com.example.listview_02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MyActivity extends Activity {
    private ListView listView;

    private SimpleAdapter adapter;

    private List<Map<String,String>> data = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView)findViewById(R.id.listView);

        data = MyDataSources.getMaps();

        adapter = new SimpleAdapter(MyActivity.this,data,R.layout.main,new String[]{"pname","pprice","paddr"},new int[]{R.id.pname,R.id.pprice,R.id.paddr});

        listView.setAdapter(adapter);
    }


}
