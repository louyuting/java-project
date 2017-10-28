package com.example.demo.test.aopdemo.service;

import com.example.demo.test.aopdemo.annotation.AuthorityCheck;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public interface UserService {
    @AuthorityCheck(authorityCode = {"test1", "test2"})
    void updateUser();
}
