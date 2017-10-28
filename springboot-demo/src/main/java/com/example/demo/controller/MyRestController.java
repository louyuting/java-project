package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/30
 */
@RestController
@RequestMapping(value = "/rest")
public class MyRestController {

    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    public User getUser(@PathVariable String user) {
        User user1 = new User();
        user1.setId("id0001");
        user1.setName(user);
        return user1;
    }
}
