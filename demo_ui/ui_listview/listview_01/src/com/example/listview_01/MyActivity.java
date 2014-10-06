package com.example.listview_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.List;

public class MyActivity extends Activity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> data = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        data = MyDataSources.getDataSources();
        listView = (ListView)findViewById(R.id.listView);

        //adapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_list_item_1,data);
        adapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_list_item_single_choice,data);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MyActivity.this,"click me",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
