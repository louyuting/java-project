package com.example.mockito.relay;

import java.util.List;

import org.mockito.ArgumentMatcher;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class ListOfTwoElements implements ArgumentMatcher<List> {

    public ListOfTwoElements() {
    }

    @Override
    public boolean matches(List list) {
        return list.size()==2;
    }

    @Override
    public String toString() {
        return "list of 2 elements";
    }
}
