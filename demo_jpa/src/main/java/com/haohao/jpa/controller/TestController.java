package com.haohao.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 * @date 2022年06月07日 14:35
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello docker";
    }
}
