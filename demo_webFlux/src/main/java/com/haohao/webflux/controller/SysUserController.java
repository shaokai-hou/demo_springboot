package com.haohao.webflux.controller;

import com.haohao.webflux.domain.SysUser;
import com.haohao.webflux.mapper.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author haohao
 * @date 2022年05月30日 15:35
 */
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class SysUserController {

    final SysUserRepository sysUserRepository;

    @GetMapping("/list")
    public Flux<SysUser> list() {
        return sysUserRepository.findAll();
    }
}
