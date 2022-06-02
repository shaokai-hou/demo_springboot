package com.haohao.redis.controller;

import com.haohao.redis.domain.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 */
@Slf4j
@RestController
public class TestCache {

    @GetMapping("/test/{id}")
    @Cacheable(value = {"user"}, key = "#id")
    public TestVo test(@PathVariable("id") Long id) {
        log.error("TestCache test()");
        return new TestVo(id, "张三");
    }
}
