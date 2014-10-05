package com.example.spinner_01.adapter;

import com.example.spinner_01.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chang on 14-10-5.
 */
public class MyAdapter {
    public MyAdapter() {

    }

    public static List<String> getData() {
        List<String> list = new ArrayList<String>();
        list.add("beijin");
        list.add("shanghai");
        list.add("hefei");

        return list;
    }

    public static List<Map<String, Object>> getListMaps() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ivLogo", R.drawable.ic_launcher);
        map.put("applicationName", "日历");

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("ivLogo", R.drawable.ic_launcher);
        map2.put("applicationName", "日志");

        list.add(map);
        list.add(map2);
        return list;
    }


}
