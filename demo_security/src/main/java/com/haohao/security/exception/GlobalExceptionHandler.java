package com.haohao.security.exception;

import com.demo.common.result.ResultCodeEnum;
import com.demo.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author haohao
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 通用异常处理方法
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData error(Exception e) {
        log.error("异常信息", e);
        return ResultData.error();
    }

    /**
     * 空指针异常处理
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultData error(NullPointerException e) {
        log.error("空指针异常信息", e);
        return ResultData.setResult(ResultCodeEnum.NULL_POINT);
    }

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResultData handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        log.error("请求地址{},权限校验失败{}", requestUrl, e.getMessage());
        return ResultData.setResult(ResultCodeEnum.FORBIDDEN);
    }
}
