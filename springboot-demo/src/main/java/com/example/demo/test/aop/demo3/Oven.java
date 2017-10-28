package com.example.demo.test.aop.demo3;

/**
 * 烤箱
 * Created by louyuting on 17/1/21.
 */
public class Oven {
    private String name = "";

    public Oven() {
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
