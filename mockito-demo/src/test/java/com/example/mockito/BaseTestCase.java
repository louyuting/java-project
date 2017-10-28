package com.example.mockito;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * description mockito基础测试类， 继承该类就可在执行 unit test之前初始化 @Mock对象。
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class BaseTestCase {
    @Before
    public void initMocks(){
        // 显示调用初始化mock 对象
        MockitoAnnotations.initMocks(this);
    }
}
