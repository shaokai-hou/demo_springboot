package com.haohao.security.controller;

import com.demo.common.result.ResultData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haohao.security.domain.CustomUserDetails;
import com.haohao.security.domain.SecUser;
import com.haohao.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    final AuthenticationManager authenticationManager;
    final JwtUtils jwtUtils;
    final StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public ResultData login(String username, String password) throws JsonProcessingException {
        // 该方法会去调用SecUserServiceImpl.loadUserByUsername
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        CustomUserDetails customUserDetails = (CustomUserDetails) authenticate.getPrincipal();
        String token = jwtUtils.createToken(customUserDetails.getId());
        // 放入缓存
        stringRedisTemplate.opsForValue().set(customUserDetails.getId().toString(), new ObjectMapper().writeValueAsString(customUserDetails));
        return ResultData.success().data(token);
    }
}
