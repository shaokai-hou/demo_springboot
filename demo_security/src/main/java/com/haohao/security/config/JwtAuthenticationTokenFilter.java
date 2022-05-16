package com.haohao.security.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haohao.security.domain.CustomUserDetails;
import com.haohao.security.domain.SecPermission;
import com.haohao.security.domain.SecRole;
import com.haohao.security.domain.SecUser;
import com.haohao.security.jwt.JwtConfig;
import com.haohao.security.jwt.JwtUtils;
import com.haohao.security.mapper.SecPermissionMapper;
import com.haohao.security.mapper.SecRoleMapper;
import com.haohao.security.mapper.SecUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haohao
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    final SecRoleMapper secRoleMapper;
    final SecPermissionMapper secPermissionMapper;
    final SecUserMapper secUserMapper;
    final JwtConfig jwtConfig;
    final JwtUtils jwtUtils;
    final StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {

        String token = request.getHeader(jwtConfig.getHeader());
        if (StrUtil.isNotBlank(token)) {
            Long loginUserId = jwtUtils.getLoginUser(request);
            // 缓存中获取对象
            String s = stringRedisTemplate.opsForValue().get(loginUserId.toString());
            CustomUserDetails loginUser = new ObjectMapper().readValue(s, CustomUserDetails.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filter.doFilter(request, response);
    }
}
