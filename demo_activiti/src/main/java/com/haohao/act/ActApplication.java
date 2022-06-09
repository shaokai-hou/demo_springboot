package com.haohao.act;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author haohao
 * @date 2022年06月02日 16:50
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActApplication.class, args);
    }
}
