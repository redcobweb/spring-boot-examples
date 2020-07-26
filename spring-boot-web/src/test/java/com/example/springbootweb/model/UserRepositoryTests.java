package com.example.springbootweb.model;

import com.example.springbootweb.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa","aa123456","aa@126.com","aa1",formattedDate));
        userRepository.save(new User("bb","bb123456","bb@126.com","bb2",formattedDate));
        userRepository.save(new User("cc","cc123456","cc@126.com","cc3",formattedDate));

        Assert.assertEquals(3,userRepository.findAll().size());
        Assert.assertEquals("bb2",userRepository.findByUserNameOrEmail("bb","xxx126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("cc"));


    }

}
