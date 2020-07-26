package com.example.springbootweb.web;

import com.example.springbootweb.util.ZacProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTests {

    @Autowired
    private ZacProperties zacProperties;

    @Test
    public void getHello() throws Exception{
        System.out.println(zacProperties.getTitle());
        Assert.assertEquals(zacProperties.getTitle(),"纯洁的微笑");
        Assert.assertEquals(zacProperties.getDescription(),"分享技术与生活");
    }

    @Test
    public void testMap() throws Exception{
        Map<String,Long> orderMinTime = new HashMap<String,Long>();
        Long xx = orderMinTime.get("123");
        System.out.println(xx);
    }
}
