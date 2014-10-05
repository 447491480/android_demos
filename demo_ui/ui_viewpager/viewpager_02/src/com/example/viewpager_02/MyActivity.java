package com.example.viewpager_02;

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

    private MyAdapter myAdapter = null;
    private List<View> list = null;
    private List<String> title = null;
    private LayoutInflater inflater = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        pagerTitleStrip = (PagerTitleStrip)findViewById(R.id.viewPagerTitle);

        myAdapter = new MyAdapter();

        inflater = LayoutInflater.from(MyActivity.this);
        View tab = inflater.inflate(R.layout.tab,null);
        list = new ArrayList<View>();
        list.add(tab);

        title = new ArrayList<String>();
        title.add("title");

        viewPager.setAdapter(myAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            ((ViewPager)container).removeView(list.get(position));

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }

}
