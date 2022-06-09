package com.haohao.satoken.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.haohao.satoken.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 * @date 2022年06月08日 17:16
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        String username = "admin";
        String password = "123456";
        if (StrUtil.equals(username, loginRequest.getUsername()) && StrUtil.equals(password, loginRequest.getPassword())) {
            log.info("login success");
            StpUtil.login(1L);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            log.info("login token :{}", tokenInfo);
        }
    }

    public void logout(){

    }
}
