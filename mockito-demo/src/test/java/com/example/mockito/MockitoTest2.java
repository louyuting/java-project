package com.example.mockito;

import com.example.mockito.relay.ArticleCalculator;
import com.example.mockito.relay.ArticleDatabase;
import com.example.mockito.relay.ArticleManager;
import com.example.mockito.relay.UserProvider;
import org.junit.Before;
import org.mockito.Mock;

/**
 * description:Mockito 测试ArticleManager.java
 * 这里首先调用BaseTestCase 里面的 @before 方法，初始化mock对象
 * 这个类里面主要有以下几点：
 *      9. 标准创建 mock 方式 - 使用 @Mock 注解
 *
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class MockitoTest2 extends BaseTestCase{
    @Mock  // 这里用@Mock 注解的类还没有初始化，必须调用手动初始化：MockitoAnnotations.initMocks(this);
    private ArticleCalculator calculator;
    @Mock
    private ArticleDatabase database;
    @Mock
    private UserProvider userProvider;

    private ArticleManager manager;

    @Before
    public void before(){
        this.manager = new ArticleManager(calculator, database,userProvider);
    }
}
