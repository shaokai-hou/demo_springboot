package com.haohao.rabbitmq.config;

import com.haohao.rabbitmq.constant.ExchangeConstant;
import com.haohao.rabbitmq.constant.QueueConstant;
import com.haohao.rabbitmq.constant.RouterConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连交换机
 *
 * @author haohao
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 定义交换机
     *
     * @return DirectExchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(ExchangeConstant.DEFAULT_EXCHANGE, true, false);
    }

    /**
     * 定义队列
     *
     * @return Queue
     */
    @Bean
    public Queue directQueue() {
        return new Queue(QueueConstant.MESSAGE_QUEUE, true);
    }

    /**
     * 队列绑定交换机
     *
     * @return Binding
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind((directQueue())).to(directExchange()).with(RouterConstant.DEFAULT_ROUTER);
    }
}
