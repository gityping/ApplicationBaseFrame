package com.yping.applicationbaseframe.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dealJsonUtil {
    /*
     * 获取"数组形式"的JSON数据，
     */
    public static List<Map<String, String>> getJSONArray(String path) throws Exception {
        String json = null;
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        URL url = new URL(path);
/**HttpURLConnection对象,从网络中获取网页数据*/
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
/**设置超时时间为5秒*/
        conn.setConnectTimeout(5 * 1000);
/**HttpURLConnection是通过HTTP协议请求path路径的，所以需要设置请求方式,可以不设置，因为默认为GET*/
        conn.setRequestMethod("GET");
/**判断请求是否成功，成功时请求码为200，否则失败*/
        if (conn.getResponseCode() == 200) {
/**获取数据输入流*/
            InputStream is = conn.getInputStream();
/**把输入流转换成字符数组*/
            byte[] data = readStream2Array(is);
/**字符数组转换成字符串*/
            json = new String(data);
            /*
             * 数据形式：[{"stuNo":100,"name":"小明"},{"stuNo":101,"name":"小张"}]数据为数组形式，直接用android框架 JSONArray读取数据，转换成Array
             */
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
/**获取每条数据中的对象*/
                JSONObject item = jsonArray.getJSONObject(i);
/**注意key值要一致*/
                int id = item.getInt("stuNo");
                String name = item.getString("name");
                map = new HashMap<String, String>();
                map.put("stuNo", id + "");
                map.put("name", name);
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 获取"对象形式"的JSON数据，
     *
     * @param path 网页路径
     * @return 返回List
     * @throws Exception
     */
    public static List<Map<String, String>> getJSONObject(String path) throws Exception {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000); // 单位是毫秒，设置超时时间为5秒
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();
            byte[] data = readStream2Array(is);
            String json = new String(data);
            /*
             * 数据形式：{"total":2,"success":true,"arrayData":[{"id":1,"name":"小猪"},{"id":2,"name":"小猫"}]}
             * 返回的数据形式是一个Object类型，所以可以直接转换成一个Object*/
            JSONObject jsonObject = new JSONObject(json);
            int total = jsonObject.getInt("total");
            Boolean success = jsonObject.getBoolean("success");
/**json对象中有一个数组数据，又可以使用getJSONArray获取数组*/
            JSONArray jsonArray = jsonObject.getJSONArray("arrayData");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                int id = item.getInt("id");
                String name = item.getString("name");
                map = new HashMap<String, String>();
                map.put("id", id + "");
                map.put("name", name);
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 获取类型复杂的JSON数据
     */
    public static List<Map<String, String>> getComplexJSON(String path) throws Exception {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();
            byte[] data = readStream2Array(is);
            String json = new String(data);
            /*
             * 数据形式： {"name":"小猪", "age":23, "content":{"questionsTotal":2, "questions": [ { "question": "what's your name?", "answer": "小猪"}, {"question": "what's your age", "answer": "23"}] } }
             */
            JSONObject jsonObject = new JSONObject(json);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            Log.i("abc", "name:" + name + " | age:" + age);
            JSONObject contentObject = jsonObject.getJSONObject("content");
            String questionsTotal = contentObject.getString("questionsTotal");
            JSONArray contentArray = contentObject.getJSONArray("questions");
            for (int i = 0; i < contentArray.length(); i++) {
                JSONObject item = contentArray.getJSONObject(i);
                String question = item.getString("question");
                String answer = item.getString("answer");
                map = new HashMap<String, String>();
                map.put("question", question);
                map.put("answer", answer);
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 把输入流转换成字符数组
     */
    public static byte[] readStream2Array(InputStream inputStream) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            bout.write(buffer, 0, len);
        }
        bout.close();
        inputStream.close();
        return bout.toByteArray();
    }
}
