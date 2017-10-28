package com.example.mockito;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * description:
 *      10. Stubbing 连续调用（迭代器式的 stubbing）
 *      12. doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() 家族方法
 *      13. 监控真实对象:使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class MockitoTest4 extends BaseTestCase{
    @Mock
    List mockedList;

    @Test(expected = RuntimeException.class)
    public void test(){
        when(mockedList.add(anyString())).thenThrow(new RuntimeException()).thenReturn(true);
        // first invoke: throw RuntimeException
        mockedList.add("test1");
    }

    @Test
    public void test2(){
        when(mockedList.toString()).thenReturn("one", "two", "three");
        // second invoke: return true
        System.err.println(mockedList.toString());
        //Any consecutive call: prints "foo" as well (last stubbing wins).
        System.out.println(mockedList.toString());
    }


    // doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() 家族方法
    // 用于 Stubbing void 方法中，doThrow(Throwable…) 取代 stubVoid(Object)
    @Test(expected = RuntimeException.class)
    public void test3(){
        doThrow(new RuntimeException()).when(mockedList).clear();
        //following throws RuntimeException:
        mockedList.clear();
    }


    // spy 监控真实对象
    @Test public void test4(){
        List list = new LinkedList();
        List spy = spy(list);
        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);
        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");
        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());
        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
        spy.add("three");
        System.out.println(spy.size());
    }

    //使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
    @Test(expected = IndexOutOfBoundsException.class)
    public void test5(){
        List list = new LinkedList();
        List spy = spy(list);
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");
        //You have to use doReturn() for stubbing
        // 使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn("foo").when(spy).get(0);
    }

}
