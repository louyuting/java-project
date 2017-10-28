package com.example.mockito;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

/**
 * description: 使用注解@RunWith(MockitoJUnitRunner.class) 来初始化 @Mock 对象
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest3 {
    @Mock
    private List mockList;

    @Test
    public void test1(){
        mockList.add(1);
        verify(mockList).add(1);
    }
}
