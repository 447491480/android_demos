package com.example.textview_01;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView textView1;
    private TextView textView2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview2);

        String html = "<font color='red' >I love android</font>";
        html += "<font color='#0000ff'><big><i>I love Android,too</i></big></font>";
        html += "<big><a href='http://www.baidu.com'>百度</a><big>";

        CharSequence charSequence = Html.fromHtml(html);
        textView1.setText(charSequence);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        String text = "我得URL：http://www.sina.com\n";
        text += "我的email:abdsd@126.com\n";
        text += "我的电话：+86 010-78652312";

        textView2.setText(text);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
