package com.example.listview_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chang on 14-10-6.
 */
public class MyDataSources {

    public static List<Map<String,String>> getMaps() {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();

        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("pname","xigua");
        map1.put("pprice","11");
        map1.put("paddr","shanghai");

        list.add(map1);

        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("pname","xigua");
        map2.put("pprice","11");
        map2.put("paddr","shanghai");

        list.add(map2);

        Map<String,String> map3 = new HashMap<String, String>();
        map3.put("pname","xigua");
        map3.put("pprice","11");
        map3.put("paddr","shanghai");

        list.add(map3);

        return  list;
    }
}
