package com.haohao.rabbitmq.producer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SendMessageServiceTest {

    @Resource
    private SendMessageService sendMessageService;

    @Test
    void sendMessage() {
        while (true) {
            sendMessageService.sendMessage("我是消息");
        }
    }
}