package com.example.viewstud_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;

public class MyActivity extends Activity {
    private Button button1,button2;
    private ViewStub viewStub;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        viewStub = (ViewStub)findViewById(R.id.stub);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = viewStub.inflate();
                LinearLayout layout = (LinearLayout)view;
                RatingBar bar = (RatingBar)layout.findViewById(R.id.ratingBar);
                bar.setNumStars(3);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.setVisibility(View.GONE);
            }
        });

    }


}
