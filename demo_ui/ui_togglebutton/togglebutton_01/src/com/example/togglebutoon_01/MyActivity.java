package com.example.togglebutoon_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MyActivity extends Activity {
    private ToggleButton tb;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tb = (ToggleButton)findViewById(R.id.toggleBtn);

        final LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.subLayout);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                } else {
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        });
    }
}
