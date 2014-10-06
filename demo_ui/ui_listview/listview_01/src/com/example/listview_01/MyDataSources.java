package com.example.listview_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chang on 14-10-5.
 */
public class MyDataSources  {
    public static List<String> getDataSources() {
        List<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("hefei");
        list.add("shanghai");
        list.add("shenzhen");
        list.add("dalian");

        return  list;
    }
}