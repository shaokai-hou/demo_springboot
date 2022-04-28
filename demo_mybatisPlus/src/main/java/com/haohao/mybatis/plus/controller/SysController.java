package com.haohao.mybatis.plus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haohao.mybatis.plus.domain.SysUserEntity;
import com.haohao.mybatis.plus.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haohao
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/user")
public class SysController {

    final ISysUserService sysUserService;
    final ObjectMapper json;

    @GetMapping("/list")
    public String list() throws JsonProcessingException {
        List<SysUserEntity> list = sysUserService.list();
        return json.writeValueAsString(list);
    }

    @GetMapping("/date")
    public String dateFormat() throws JsonProcessingException {
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String, Object> result = new HashMap<>(2);
        result.put("date", date);
        result.put("localDate", localDate);
        result.put("localDateTime", localDateTime);
        return json.writeValueAsString(result);
    }
}
