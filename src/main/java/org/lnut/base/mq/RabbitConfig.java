package org.lnut.base.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther ZhaoXin
 * @Date 2020/9/1
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue DirectQueue(@Value("direct") String name) {
        return new Queue(name, true);
    }

}

