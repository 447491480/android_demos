package com.example.file_01;

import android.os.Environment;

import java.io.*;

/**
 * Created by chang on 14-10-9.
 */
public class FileService {

    public static boolean saveToSdcard(String fileName,String content) {
        boolean flag = false;
        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),fileName);
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            try {
                if(!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);

                fileOutputStream.write(content.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



        return flag;
    }

    public static String readFileContent(String fileName) {
        FileInputStream inputStream = null;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file = new File(Environment.getExternalStorageDirectory(),fileName);

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) try {
            inputStream = new FileInputStream(file);

            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        return  new String(byteArrayOutputStream.toByteArray());

    }
}
