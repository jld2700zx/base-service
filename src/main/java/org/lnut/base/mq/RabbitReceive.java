package org.lnut.base.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther ZhaoXin
 * @Date 2020/9/1
 */
@Component
public class RabbitReceive<T> {

//    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public T receive(T t) {
        System.out.println(t);
        return t;
    }
}
