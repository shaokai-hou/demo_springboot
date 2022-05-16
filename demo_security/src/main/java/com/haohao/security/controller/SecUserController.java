package com.haohao.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.result.ResultData;
import com.haohao.security.domain.SecUser;
import com.haohao.security.service.SecUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SecUserController {

    final SecUserService secUserService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public ResultData list(SecUser secUser) {
        return ResultData.success().data(secUserService.list(new QueryWrapper<>(secUser)));
    }

    @PostMapping
    @PreAuthorize("@ss.hasPermission('system:user:save')")
    public ResultData save(@Validated @RequestBody SecUser secUser) {
        return ResultData.flag(secUserService.save(secUser));
    }

    @PutMapping
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public ResultData update(@Validated @RequestBody SecUser secUser) {
        return ResultData.flag(secUserService.updateById(secUser));
    }
}
