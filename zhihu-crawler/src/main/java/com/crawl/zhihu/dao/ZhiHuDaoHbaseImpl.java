package com.crawl.zhihu.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;

import com.crawl.core.util.Constants;
import com.crawl.zhihu.entity.User;

/**
 * 数据访问层， hbase实现
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/17
 */
public class ZhiHuDaoHbaseImpl implements ZhiHuDao {
    private static Logger logger =  Constants.ZHIHU_LOGGER;

    /**
     * 数据库表初始化
     */
    public static void DBTablesInit() {
        Properties properties = new Properties();
        try {
            properties.load(ZhiHuDaoHbaseImpl.class.getResourceAsStream("/config.properties"));
            String tableUser = properties.getProperty("db.hbase.table.name.user");// 获取hbase的table的名称
            String tableUrl = properties.getProperty("db.hbase.table.name.url");// 获取hbase的table的名称



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isExistRecord(String sql) throws SQLException {
        return false;
    }

    @Override
    public boolean isExistRecord(Connection cn, String sql) throws SQLException {
        return false;
    }

    @Override
    public boolean isExistUser(String userToken) {
        return false;
    }

    @Override
    public boolean isExistUser(Connection cn, String userToken) {
        return false;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public boolean insertUser(Connection cn, User user) {
        return false;
    }

    @Override
    public boolean insertUrl(Connection cn, String md5Url) {
        return false;
    }
}
