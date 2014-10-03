package com.example.autocompletetextview_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MyActivity extends Activity {
    private AutoCompleteTextView act;
    private MultiAutoCompleteTextView mact;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        act = (AutoCompleteTextView)findViewById(R.id.autoComplete);
        mact = (MultiAutoCompleteTextView)findViewById(R.id.mulAuto);
        String[] autoString = new String[] {
                "orange","apple","google","microsoft"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_dropdown_item_1line,autoString);

        act.setAdapter(arrayAdapter);

        mact.setAdapter(arrayAdapter);
        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
