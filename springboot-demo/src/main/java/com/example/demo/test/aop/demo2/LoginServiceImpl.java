package com.example.demo.test.aop.demo2;

/**
 * Created by louyuting on 17/1/20.
 */
public class LoginServiceImpl {
    public void login(User user, String operationId) {
        if (user != null) {
            System.out.println(operationId + "->"+user.getName() + " login");
        }
    }

}
