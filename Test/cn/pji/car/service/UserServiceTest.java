package cn.pji.car.service;

import cn.pji.car.domain.User;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//junit4测试service的login方法
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:spring-mvc.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void login() {
        User user =userService.login("admin","123321");
        if(user!=null){
            System.err.println("测试成功");
        }
    }
}