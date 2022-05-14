package com.haohao.rabbitmq.producer;

import com.haohao.rabbitmq.constant.ExchangeConstant;
import com.haohao.rabbitmq.constant.RouterConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haohao
 */
@Slf4j
@Service
public class SendMessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Object message) {
        rabbitTemplate.convertAndSend(ExchangeConstant.DEFAULT_EXCHANGE, RouterConstant.DEFAULT_ROUTER, message);
    }
}
