package com.example.springbootredis;

import com.example.springbootredis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception{
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));

    }

    @Test
    public void testObj()throws Exception{
        User user = new User("aa", "aa123456", "aa@126.com", "aa1", "123");
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("com.example.aa",user);
        operations.set("com.example.aa1",user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        redisTemplate.delete("com.example.aa1");
        Boolean hasKey = redisTemplate.hasKey("com.example.aa1");
        if (hasKey){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        Assert.assertEquals("aa",operations.get("com.example.aa1").getUserName());
    }
}
