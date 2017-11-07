package com.crawl.zhihu.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ZhihuDAOTest {
    @Test
    public void testDBTablesInit(){
        ZhiHuDaoMysqlImpl.DBTablesInit();
        ZhiHuDao zhiHuDao = new ZhiHuDaoMysqlImpl();
        List<String> res = zhiHuDao.listUserTokenLimitNumOrderById(1, 5);
        Assert.assertTrue(res.size() == 5);
        System.out.println(res);
    }
}
