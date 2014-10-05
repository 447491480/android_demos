package com.example.spinner_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import com.example.spinner_01.adapter.MyAdapter;

import java.util.List;
import java.util.Map;

public class MyActivity extends Activity {
    private Spinner spinner;
    private Spinner spinner2;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);

        List<String> list = MyAdapter.getData();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_spinner_item,list);

        spinner.setAdapter(arrayAdapter);
        List<Map<String, Object>> data = MyAdapter.getListMaps();
        SimpleAdapter simpleAdapter = new SimpleAdapter(MyActivity.this,data,R.layout.items,new String[]{"ivLogo","applicationName"},new int[]{R.id.imageView,R.id.textview});

        spinner2.setAdapter(simpleAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = ((Map<String,Object>)spinner2.getItemAtPosition(i)).get("applicationName").toString();

                setTitle(name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
