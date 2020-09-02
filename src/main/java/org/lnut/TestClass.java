package org.lnut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnut.base.mq.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther ZhaoXin
 * @Date 2020/9/1
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestClass {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void test() {
        rabbitSender.send("hello");
    }
}
