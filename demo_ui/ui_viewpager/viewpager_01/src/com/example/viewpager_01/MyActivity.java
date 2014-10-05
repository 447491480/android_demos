package com.example.viewpager_01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    private ViewPager viewPager;
    private PagerTitleStrip pagerTitleStrip;
    private List<View> list;
    private List<String> titleList;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        pagerTitleStrip = (PagerTitleStrip)findViewById(R.id.viewPagerTitle);

        View view1 = LayoutInflater.from(MyActivity.this).inflate(R.layout.tab1,null);
        View view2 = LayoutInflater.from(MyActivity.this).inflate(R.layout.tab2,null);
        View view3 = LayoutInflater.from(MyActivity.this).inflate(R.layout.tab3,null);

        list = new ArrayList<View>();
        list.add(view1);list.add(view2);list.add(view3);
        titleList = new ArrayList<String>();
        titleList.add("tab1");titleList.add("tab2");titleList.add("tab3");

        viewPager.setAdapter(new MyAdapter());

    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
             //super.destroyItem(container,position,object);

            ((ViewPager)container).removeView(list.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(list.get(position));
            return list.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }
}
