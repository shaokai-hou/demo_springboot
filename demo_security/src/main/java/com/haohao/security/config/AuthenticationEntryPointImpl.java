package com.haohao.security.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import com.demo.common.result.ResultCodeEnum;
import com.demo.common.result.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Security认证失败处理类
 *
 * @author haohao
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        String msg = StrUtil.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        ResultData resultData = ResultData.setResult(ResultCodeEnum.UNAUTHORIZED).data(msg);
        response.getWriter().print(new ObjectMapper().writeValueAsString(resultData));
    }
}