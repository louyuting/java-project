package com.crawl.zhihu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.crawl.zhihu.entity.User;

public interface ZhiHuDao {
    /**
     * 判断当前sql执行的操作记录是否已经存在
     * @param sql
     * @return
     * @throws SQLException
     */
    boolean isExistRecord(String sql) throws SQLException;

    boolean isExistRecord(Connection cn, String sql) throws SQLException;

    /**
     * 判断当前user是否已经存在
     * @param userToken
     * @return
     */
    boolean isExistUser(String userToken);

    boolean isExistUser(Connection cn, String userToken);

    /**
     * 插入一个user
     * @param user
     * @return
     */
    boolean insertUser(User user);

    boolean insertUser(Connection cn, User user);

    /**
     * 插入url,插入成功返回true，若已存在该url则返回false
     * @param cn
     * @param md5Url
     * @return
     */
    boolean insertUrl(Connection cn, String md5Url);
}
