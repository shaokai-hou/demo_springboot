package com.haohao.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.result.ResultData;
import com.haohao.security.domain.SecRole;
import com.haohao.security.service.SecRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class SecRoleController {

    final SecRoleService secRoleService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:role:list')")
    public ResultData list(SecRole secRole) {
        return ResultData.success().data(secRoleService.list(new QueryWrapper<>(secRole)));
    }

    @PostMapping
    @PreAuthorize("@ss.hasPermission('system:role:save')")
    public ResultData save(@Validated @RequestBody SecRole secRole) {
        return ResultData.flag(secRoleService.save(secRole));
    }

    @PutMapping
    @PreAuthorize("@ss.hasPermission('system:role:update')")
    public ResultData update(@Validated @RequestBody SecRole secRole) {
        return ResultData.flag(secRoleService.updateById(secRole));
    }
}
