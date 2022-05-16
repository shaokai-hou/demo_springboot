package com.haohao.security.jwt;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.haohao.security.domain.CustomUserDetails;
import com.haohao.security.domain.SecUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haohao
 */
@Component
@RequiredArgsConstructor
public class JwtUtils {

    final JwtConfig jwtConfig;

    public String createToken(Long userId) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(JwtConstant.LOGIN_USER_ID, userId);
        return createToken(claims);
    }

    /**
     * 获取用户身份认证信息
     *
     * @param request request
     * @return 当前登录用户
     */
    public Long getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        Claims claims = parseToken(token);
        // 解析对应的权限以及用户信息
        return claims.get(JwtConstant.LOGIN_USER_ID, Long.class);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取请求token
     *
     * @param request request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isNotEmpty(token) && token.startsWith(JwtConstant.TOKEN_PREFIX)) {
            token = token.replace(JwtConstant.TOKEN_PREFIX, "");
        }
        return token;
    }
}
