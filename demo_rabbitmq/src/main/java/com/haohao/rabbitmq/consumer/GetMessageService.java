package com.haohao.rabbitmq.consumer;

import com.haohao.rabbitmq.constant.QueueConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author haohao
 */
@Slf4j
@Component
public class GetMessageService {

    @RabbitListener(queues = QueueConstant.MESSAGE_QUEUE)
    public void getMessage1(@Payload String body, @Headers Map<String, Object> headers, Message message, Channel channel) throws IOException {
        try {
            log.info("接受到消息 method: getMessage1");
            log.info("接受到消息 body:{}", body);
            log.info("接受到消息 headers:{}", headers);
            log.info("接受到消息 message:{}", message);
            log.info("接受到消息 channel:{}", channel);
            // 模拟处理消息
            Thread.sleep(3000);
            // 确认消息已经消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = QueueConstant.MESSAGE_QUEUE)
    public void getMessage2(@Payload String body, @Headers Map<String, Object> headers, Message message, Channel channel) throws IOException {
        try {
            log.info("接受到消息 method: getMessage2");
            log.info("接受到消息 body:{}", body);
            log.info("接受到消息 headers:{}", headers);
            log.info("接受到消息 message:{}", message);
            log.info("接受到消息 channel:{}", channel);
            // 模拟处理消息
            Thread.sleep(3000);
            // 确认消息已经消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
