package com.example.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.example.fastjson.domain.Info;
import org.junit.Test;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/21
 */
public class JSONObjectTest {
    @Test
    public void test_JSONObject_1(){
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("errorCode", 1);
        Info info = new Info();
        info.setAddressId("12324357689");
        info.setContactName("楼听");
        info.setPhone("12345697564");
        json.put("data", info);
        // 下面两个输出一样
        /**
         * {"data":{"addressId":"12324357689","contactName":"楼听","phone":"12345697564"},"success":true,"errorCode":1}
         * {"data":{"addressId":"12324357689","contactName":"楼听","phone":"12345697564"},"success":true,"errorCode":1}
         */
        System.out.println(json.toJSONString());
        System.out.println(json.toString());
    }

    @Test
    public void test_2(){
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("errorCode", 1);
        json.put("msg", null);
        System.err.println(json.toJSONString());
        /**
         * 输出是：{"success":true,"errorCode":1}， 也就是当 key非空， value为空时候就不会将这个key value存入
         */
    }

    @Test
    public void test_map_value_null(){
        Map<String, Object> map = new HashMap<>();
        map.put("key", null);
        System.out.println(map.size());
    }


    @Test
    public void test_json_json(){

    }

}
