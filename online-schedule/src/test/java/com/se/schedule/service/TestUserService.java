package com.se.schedule.service;

import com.se.schedule.entity.User;
import com.se.schedule.service.impl.UserServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 4:08 下午
 */
@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;
    @Test
    @Ignore
    public void testIoginByUserNameAndPwd(){
        int code  =userService.loginByUserNameAndPwd("abc","abd");

    }
    @Test
    @Ignore
    public void testInsert(){
        int code  = userService.signUpByUserNameAndPwd("abc","abd");
        System.out.println(code);

    }
}
