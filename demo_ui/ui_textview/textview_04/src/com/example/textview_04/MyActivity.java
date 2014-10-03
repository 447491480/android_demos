package com.example.textview_04;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv = (TextView)findViewById(R.id.textview);
        String txt = "<a href='http://www.cnblogs.com/rollenholt/archive/2011/09/02/2163758.html'>本篇文章</a>依旧采用小例子来说明，因为我始终觉的，案例驱动是最好的，要不然只看理论的话，看了也不懂，不过建议大家在看完文章之后，在回过头去看看理论，会有更好的理解";

        CharSequence charSequence = Html.fromHtml(txt);
        tv.setText(charSequence);
        //tv.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
