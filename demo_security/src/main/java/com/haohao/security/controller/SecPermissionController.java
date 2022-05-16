package com.haohao.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.result.ResultData;
import com.haohao.security.domain.SecPermission;
import com.haohao.security.domain.SecRole;
import com.haohao.security.service.SecPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class SecPermissionController {

    final SecPermissionService secPermissionService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:permission:list')")
    public ResultData list(SecPermission secPermission) {
        return ResultData.success().data(secPermissionService.list(new QueryWrapper<>(secPermission)));
    }

    @PostMapping
    @PreAuthorize("@ss.hasPermission('system:permission:save')")
    public ResultData save(@Validated @RequestBody SecPermission secPermission) {
        return ResultData.flag(secPermissionService.save(secPermission));
    }

    @PutMapping
    @PreAuthorize("@ss.hasPermission('system:permission:update')")
    public ResultData update(@Validated @RequestBody SecPermission secPermission) {
        return ResultData.flag(secPermissionService.updateById(secPermission));
    }
}
