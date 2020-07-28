package com.example.springbootredis.web;

import com.example.springbootredis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class UserController {

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser(){
        User user = new User("aa","aa123456","aa@126.com","aa","123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uid");
        if (uuid == null){
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid",uuid);
        return session.getId();

    }
}
