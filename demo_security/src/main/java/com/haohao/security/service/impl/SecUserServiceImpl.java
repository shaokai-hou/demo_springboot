package com.haohao.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.CustomUserDetails;
import com.haohao.security.domain.SecPermission;
import com.haohao.security.domain.SecRole;
import com.haohao.security.domain.SecUser;
import com.haohao.security.mapper.SecPermissionMapper;
import com.haohao.security.mapper.SecRoleMapper;
import com.haohao.security.service.SecUserService;
import com.haohao.security.mapper.SecUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("loadUserByUsername方法被执行了 username:{}", username);
        SecUser secUser = secUserMapper.selectOne(new LambdaQueryWrapper<SecUser>().eq(SecUser::getUsername, username));
        List<SecRole> secRoles = secRoleMapper.selectRoleListByUserId(secUser.getId());
        List<Long> roleId = secRoles.stream().map(SecRole::getId).collect(Collectors.toList());
        List<SecPermission> permissions = secPermissionMapper.selectPermissionListByRoleIds(roleId);

        log.info("登录：secUser:{}", secUser);
        log.info("登录：secRoles:{}", secRoles);
        log.info("登录：permissions:{}", permissions);
        CustomUserDetails build = CustomUserDetails.build(secUser, secRoles, permissions);
        log.info("登录 权限:{}", build);
        return build;
    }
}




