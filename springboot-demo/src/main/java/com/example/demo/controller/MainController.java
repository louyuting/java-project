package com.example.demo.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.mapper.PreCheckMapper;
import com.example.demo.model.WaybillPrecheckRuleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/29
 */
@RestController
public class MainController {
    @Autowired
    private PreCheckMapper mapper;

    @GetMapping(value = "/test")
    public WaybillPrecheckRuleDO hello(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        // 模拟数据库的阻塞IO操作：延时10ms
        TimeUnit.MILLISECONDS.sleep(10l);
        //log.info("debug输出信息{}", res);
        WaybillPrecheckRuleDO res222 = mapper.findById(1);
        System.out.println(res222);
        return res222;
    }
}
