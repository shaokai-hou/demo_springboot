package com.haohao.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 * @date 2022年06月08日 17:25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String test1() {
        return "test1";
    }
}
