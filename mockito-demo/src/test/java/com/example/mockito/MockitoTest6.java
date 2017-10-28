package com.example.mockito;

import java.util.LinkedList;
import java.util.List;

import com.example.mockito.relay.Bar;
import com.example.mockito.relay.Foo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.*;

/**
 * description ：
 *      21. New annotations: @Captor, @Spy, @InjectMocks (Since 1.8.3)
 *
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class MockitoTest6 {
    //Instance for spying is created by calling constructor explicitly:
    @Spy
    Foo spyOnFoo = new Foo("argument");
    //Instance for spying is created by mockito via reflection (only default constructors supported):
    @Spy
    Bar spyOnBar;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    // 上面的操作其实和下面是一样的：
    @Test
    public void test1(){
        Foo spyOnFoo = Mockito.spy(new Foo("argument"));
        Bar spyOnBar = Mockito.spy(new Bar());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test2(){
        List list = new LinkedList();
        List spy = spy(list);// 转换成真实的spy List实例
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");
        doReturn("foo").when(spy).get(0);
    }

}
