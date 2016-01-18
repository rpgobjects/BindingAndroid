package com.devfestmn.bindingandroid.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chris on 1/11/16.
 */
public class AssetUtil {



    public static String loadFromAsset(String fileName, Context context){
        if(fileName.isEmpty()) {
            return "";
        }
        String data = "";
        AssetManager manager = context.getAssets();
        try {
            InputStream inputStream = manager.open(fileName);
            data =  readToEnd(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static byte[] readToEndAsArray(InputStream input) throws IOException {
        DataInputStream dis = new DataInputStream(input);
        byte[] stuff = new byte[1024];
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        int read = 0;
        while ((read = dis.read(stuff)) != -1)
        {
            buff.write(stuff, 0, read);
        }
        dis.close();
        return buff.toByteArray();
    }


    public static String readToEnd(InputStream input) throws IOException {
        return new String(readToEndAsArray(input));
    }
}
