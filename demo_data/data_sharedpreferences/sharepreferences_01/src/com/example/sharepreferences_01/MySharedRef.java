package com.example.sharepreferences_01;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chang on 14-10-9.
 */
public class MySharedRef {
    private Context context;

    public MySharedRef(Context context) {
        this.context = context;
    }

    public boolean saveMessage(String name,String pwd) {
        boolean flag = false;

        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);

        // 对数据进行编辑
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("pwd",pwd);
        flag = editor.commit();

        return flag;
    }

    public Map<String,Object> getMessage() {
        Map<String,Object> map = new HashMap<String, Object>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String pwd = sharedPreferences.getString("pwd","");
        map.put("name",name);
        map.put("pwd",pwd);

        return map;
    }
}
