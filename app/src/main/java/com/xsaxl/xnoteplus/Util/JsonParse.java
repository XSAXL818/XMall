package com.xsaxl.xnoteplus.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 处理json文件的类
 * 将inputstream转为json字符串
 */
public class JsonParse {
//    private static JsonParse instance;
    public JsonParse() {
    }
//    private JsonParse() {
//    }
//    public static JsonParse getInstance() {
//        if (instance == null) {
//            instance = new JsonParse();
//        }
//        return instance;
//    }
    /**
     * 读取JSON文件中的数据
     */
    public String read(InputStream in) {
        BufferedReader reader = null;
        StringBuilder sb = null;
        String line = null;
        try {
            sb = new StringBuilder();//实例化一个StringBuilder对象
            //用InputStreamReader把in这个字节流转换成字符流BufferedReader
            reader = new BufferedReader(new InputStreamReader(in));
            //判断从reader中读取的行内容是否为空
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (in != null) in.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}