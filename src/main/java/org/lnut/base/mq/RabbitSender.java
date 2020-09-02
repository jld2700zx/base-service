package org.lnut.base.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @Auther ZhaoXin
 * @Date 2020/9/1
 */
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

//    @Value("${spring.rabbitmq.queue.name}")
//    private String routingKey;

    public void send(Object msg) {
        rabbitTemplate.convertAndSend("direct", msg);
    }

}
