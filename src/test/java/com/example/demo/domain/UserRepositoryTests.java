package com.example.demo.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by hezhongchen on 2017/9/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("a", "a123456", "a@126.com", "a", formattedDate));
        userRepository.save(new User("b", "b123456", "b@126.com", "b", formattedDate));
        userRepository.save(new User("c", "c123456", "c@126.com", "c", formattedDate));
        userRepository.save(new User("d", "d123456", "d@126.com", "d", formattedDate));
        userRepository.save(new User("e", "e123456", "e@126.com", "e", formattedDate));

        Assert.assertEquals(5, userRepository.findAll().size());
        Assert.assertEquals("b", userRepository.findByUserName("b").getNickName());
        Assert.assertEquals("b", userRepository.findByUserNameOrEmail("b", "b@126.com").getNickName());

        userRepository.delete(userRepository.findByUserName("a"));
        userRepository.delete(userRepository.findByUserName("b"));
        userRepository.delete(userRepository.findByUserName("c"));
        userRepository.delete(userRepository.findByUserName("d"));
        userRepository.delete(userRepository.findByUserName("e"));
    }
}
