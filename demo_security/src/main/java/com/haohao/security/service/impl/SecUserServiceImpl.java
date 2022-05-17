package com.haohao.security.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.*;
import com.haohao.security.mapper.SecPermissionMapper;
import com.haohao.security.mapper.SecRoleMapper;
import com.haohao.security.mapper.SecUserRoleMapper;
import com.haohao.security.service.SecUserRoleService;
import com.haohao.security.service.SecUserService;
import com.haohao.security.mapper.SecUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author haohao
 * @description 针对表【sec_user(用户表)】的数据库操作Service实现
 * @createDate 2022-05-16 15:07:15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SecUserServiceImpl extends ServiceImpl<SecUserMapper, SecUser>
        implements SecUserService, UserDetailsService {

    final SecRoleMapper secRoleMapper;
    final SecPermissionMapper secPermissionMapper;
    final SecUserMapper secUserMapper;

    final SecUserRoleService secUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SecUser secUser = secUserMapper.selectOne(new LambdaQueryWrapper<SecUser>().eq(SecUser::getUsername, username));
        List<SecRole> secRoles = secRoleMapper.selectRoleListByUserId(secUser.getId());
        List<Long> roleId = secRoles.stream().map(SecRole::getId).collect(Collectors.toList());
        List<SecPermission> permissions = secPermissionMapper.selectPermissionListByRoleIds(roleId);
        return CustomUserDetails.build(secUser, secRoles, permissions);
    }

    /**
     * 保存用户
     *
     * @param secUser 用户
     * @return 保存结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveUser(SecUser secUser) {
        // 密码编码
        secUser.setPassword(new BCryptPasswordEncoder().encode(secUser.getPassword()));
        int insertUserFlag = secUserMapper.insert(secUser);
        if (insertUserFlag > 0) {
            List<SecUserRole> userRoles = new ArrayList<>();
            List<Long> roleIds = secUser.getSecRoles().stream().map(SecRole::getId).collect(Collectors.toList());
            roleIds.forEach(roleId -> userRoles.add(new SecUserRole(null, secUser.getId(), roleId)));
            return secUserRoleService.saveBatch(userRoles);
        }
        return false;
    }
}




