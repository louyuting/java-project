package com.example.mockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



/**
 * description:
 *      15. Capturing arguments for further assertions (Since 1.8.0) 捕获参数，用于进一步断言
 *
 *      16. 真实的部分mock. 也就是 spy
 *
 *      17. 重置mock： 清除所有的互动与预设
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class MockitoTest5 {

    // 捕获参数然后断言
    @Test
    public void test1(){
        PersonDao personDao = mock(PersonDao.class);

        PersonService personService = new PersonService(personDao);

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        personService.update(1,"jack");
        verify(personDao).update(argument.capture());
        assertEquals(1,argument.getValue().getId());
        assertEquals("jack",argument.getValue().getName());
    }


    // spy
    @Test
    public void test2(){
        //通过spy来调用真实的api
        List list = spy(new ArrayList());
        assertEquals(0,list.size());
        A a  = mock(A.class);
        //通过thenCallRealMethod来调用真实的api
        when(a.doSomething(anyInt())).thenCallRealMethod();
        assertEquals(999,a.doSomething(999));

    }

    // 重置mock
    @Test
    public void reset_mock(){
        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        list.add(2);// 由于是mock的对象，只对操作stubbing 所以并没有更改size()
        list.add(2);
        list.add(2);
        list.add(2);
        assertEquals(10,list.size());
        //重置mock，清除所有的互动和预设
        reset(list);
        assertEquals(0,list.size());
    }
}



class Person{
    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface PersonDao{
    public void update(Person person);
}

class PersonService{
    private PersonDao personDao;

    PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void update(int id,String name){
        personDao.update(new Person(id,name));
    }
}

class A{
    public int doSomething(int i){
        return i;
    }
}
