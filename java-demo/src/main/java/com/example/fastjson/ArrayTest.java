package com.example.fastjson;

import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.fastjson.domain.User;
import org.junit.Test;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/7
 */
public class ArrayTest {

    // 解析JSON数组 demo
    @Test
    public void test_array(){
        String str = "[{\"addressId\":\"6872011\",\"contactName\":\"louyuting娄娄louyuting\",\"phone\":\"13998882637\"},"
            + "{\"addressId\":\"5442009\",\"contactName\":\"lichen\",\"phone\":\"13100000000\"},"
            + "{\"addressId\":\"5022001\",\"contactName\":\"lichen\",\"phone\":\"13300000000\"}]";

        JSONArray array = JSONArray.parseArray(str);
        Object[] res = array.toArray();
        for (Object data : res){
            JSONObject da = (JSONObject)data;
            System.out.println(da.getString("phone"));
        }
    }


    @Test
    public void test_json(){
        String str = "{\"id\":[{\"addressId\":\"6872011\",\"contactName\":\"louyuting娄louyuting\","
            + "\"phone\":\"13998882637\"},{\"addressId\":\"5442009\",\"contactName\":\"lichen\","
            + "\"phone\":\"13100000000\"},{\"addressId\":\"5022001\",\"contactName\":\"lichen\","
            + "\"phone\":\"13300000000\"}], \"name\":\"louyuting\"}";

        User user  = JSON.parseObject(str, User.class);
        //System.out.println(user);
        //String res = SecurityUtil.escapeJson(str);
        //System.out.println(res);
    }

    @Test
    public void test_time(){
        ArrayTest test = new ArrayTest();
        String str = "{\"id\":[{\"addressId\":\"6872011\",\"contactName\":\"louyuting娄louyuting\","
            + "\"phone\":\"13998882637\"},{\"addressId\":\"5442009\",\"contactName\":\"lichen\","
            + "\"phone\":\"13100000000\"},{\"addressId\":\"5022001\",\"contactName\":\"lichen\","
            + "\"phone\":\"13300000000\"}], \"name\":\"louyuting\"}";
        long start = System.nanoTime();
        for (int i=0; i<50000; i++){
            JSON.parseObject(str, User.class);
        }
        long last = System.nanoTime()-start;
        System.out.println(last);
    }

    @Test
    public void main_s() throws InterruptedException {
        long start = System.nanoTime();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(System.nanoTime()-start);
    }

}
