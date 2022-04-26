package com.haohao.mybatis.plus.service;

import com.haohao.mybatis.plus.domain.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ISysUserServiceTest {

    @Autowired
    private ISysUserService sysUserService;

    @Test
    void list() {
        List<SysUserEntity> list = sysUserService.list();
        list.forEach(System.out::println);
    }

    @Test
    void insert() {
        SysUserEntity sysUser = SysUserEntity.builder().name("李四222121").status(0).phoneNumber("17392653456").build();
        sysUserService.save(sysUser);
    }

    @Test
    void update() {
        SysUserEntity sysUser = SysUserEntity.builder().id(4).name("李四1111").status(0).phoneNumber(null).build();
        sysUserService.updateById(sysUser);
    }

    @Test
    void delete() {
        sysUserService.removeById(3);
    }
}