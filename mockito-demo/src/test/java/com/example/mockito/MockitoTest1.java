package com.example.mockito;

import java.util.Arrays;
import java.util.List;

import com.example.mockito.relay.ListOfTwoElements;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.NoInteractionsWanted;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * description Mockito 测试
 * 这个类里面主要有以下几点：
 *      1.验证行为
 *      2.stubbing
 *      3.参数匹配器
 *      4.调用额外的调用数字/at least x / never
 *      5.Stubbing void 方法处理异常
 *      6.有序的验证
 *      7.确保 mock 上不会发生交互
 *      8.寻找多余的调用
 *
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 03/07/2017
 *
 * @author louyuting
 * @date 2017/07/03
 */
public class MockitoTest1 {
    List mockedList;

    @Before
    public void before(){
        mockedList = mock(List.class);
    }


    //验证行为
    @Test
    public void test1() {
        mockedList.add("one");
        mockedList.clear();
        // 验证前面的两个函数被调用过
        verify(mockedList).add("one");
        verify(mockedList).clear();
        mockedList.clear();
    }


    // stubbing
    @Test(expected = RuntimeException.class)
    public void test2(){
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        String res = (String)verify(mockedList).get(0);
        System.err.println(res);
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));
        mockedList.clear();
    }


    // 参数匹配器 1 anyInt()
    @Test
    public void test3(){
        // stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");
        // stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        //when(mockedList.contains(argThat( any() ))).thenReturn(true);
        // following prints "element"
        System.out.println(mockedList.get(999));
        // you can also verify using an argument matcher
        verify(mockedList).get(anyInt());
        mockedList.add("asdfghjkl");
        // arguement matchers can also be written as java8 lambda
        verify(mockedList).add(argThat( (String str) -> str.length() > 5) );
    }


    // 参数匹配器 2
    @Test
    public void test4(){
        when(mockedList.addAll( argThat(new ListOfTwoElements()))).thenReturn(true);
        mockedList.addAll(Arrays.asList("one", "two"));
        verify(mockedList).addAll(argThat(new ListOfTwoElements()));
        // java 8
        verify(mockedList).addAll(argThat(list -> {
            if (list==null)
                return false;
            return list.size()==2;
        }));
    }

    // 参数匹配器 3
    @Test
    public void test5(){
        mockedList.add(66, "test");
        // verify above of method invoke: third argument is "test"
        verify(mockedList).add(anyInt(),eq("test"));
    }

    // 函数调用次数的mock
    @Test
    public void test6(){
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(0)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    // stubbing 的异常方法处理：
    @Test(expected = RuntimeException.class)
    public void test7(){
        List mock = mock(List.class);
        doThrow(new RuntimeException()).when(mock).clear();
        mock.clear();
    }

    // 函数调用方法的有序验证
    @Test
    public void test8(){
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        // create an inOrder verify for a single mock list
        InOrder order = inOrder(singleMock);
        order.verify(singleMock).add("was added first");
        order.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(firstMock, secondMock);
        //following will make sure that firstMock was called before secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
        // Oh, and A + B can be mixed together at will
    }

    // 确保 mock 上不会发生交互
    @Test
    public void test9(){
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);

        //using mocks - only mockOne is interacted
        mockOne.add("one");
        //ordinary verification
        verify(mockOne).add("one");
        //verify that method was never called on a mock
        verify(mockOne, never()).add("two");

        //verify that other mocks were not interacted
        verifyZeroInteractions(mockTwo, mockThree);
    }

    //寻找多余的调用
    @Test(expected = NoInteractionsWanted.class)
    public void test10(){
        //using mocks
        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList).add("one");
        //following verification will fail,会抛出NoInteractionsWanted 的异常
        verifyNoMoreInteractions(mockedList);
    }



}















