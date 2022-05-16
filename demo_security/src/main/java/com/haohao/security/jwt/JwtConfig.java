package com.haohao.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author haohao
 */
@Data
@Component
@ConfigurationProperties("jwt")
public class JwtConfig {

    /**
     * 令牌自定义标识
     */
    private String header;
    /**
     * 令牌密钥
     */
    private String secret;
    /**
     * 令牌有效期（默认30分钟）
     */
    private String expireTime;
}
