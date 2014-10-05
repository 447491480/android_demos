package com.example.imageview_04;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chang on 14-10-4.
 */
public class HttpUtil {
    private final static String URL_PATH = "http://192.168.1.102:3000/images/1.jpg";

    public static InputStream getImageViewInputStream() throws IOException{

        InputStream inputStream = null;

        URL url = new URL(URL_PATH);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        int response_code = httpURLConnection.getResponseCode();
        if (response_code == 200) {
            inputStream = httpURLConnection.getInputStream();
        }


        return inputStream;
    }

}
