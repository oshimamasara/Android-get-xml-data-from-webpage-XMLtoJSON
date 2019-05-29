// HTMLコード読みこみ  https://stackoverflow.com/questions/6503574/how-to-get-html-source-code-from-url-in-android
// XML → JSON    https://www.youtube.com/watch?v=2nmB1sxHPps
// How to save--- https://www.youtube.com/watch?v=CNoj9vzAYiQ
package com.oshimamasara.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.util.Charsets;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";
    TextView textView;

    JSONObject jsonObject = null;
    String xml;
    String text;

    public void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Ion.with(getApplicationContext()).load("https://blog.codecamp.jp/feed.xml").asString(Charsets.UTF_8).setCallback(new FutureCallback<String>() {

            @Override
            public void onCompleted(Exception e, String result) {
                // XML → JSON
                try {
                    jsonObject = XML.toJSONObject(result);
                    Log.i(TAG,"json::"+jsonObject);
                    textView.setText(jsonObject.toString(3));
                } catch (JSONException e1) {
                    e.printStackTrace();
                }
            }
        });
    }
}


// another method  XML → JSON   https://github.com/eddydn/AndroidRSSFeed