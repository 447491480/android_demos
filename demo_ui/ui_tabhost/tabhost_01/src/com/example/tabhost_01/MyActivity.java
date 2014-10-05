package com.example.tabhost_01;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MyActivity extends TabActivity {

    private TabHost tabHost;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("系统菜单1").setIndicator("tab1",getResources().getDrawable(R.drawable.image1)));
        tabHost.addTab(tabHost.newTabSpec("系统菜单2").setIndicator("tab2",getResources().getDrawable(R.drawable.image2)));
        tabHost.addTab(tabHost.newTabSpec("系统菜单3").setIndicator("tab3",getResources().getDrawable(R.drawable.image3)));
        tabHost.addTab(tabHost.newTabSpec("系统菜单4").setIndicator("tab4",getResources().getDrawable(R.drawable.image4)));

        tabHost.setup();
    }
}
