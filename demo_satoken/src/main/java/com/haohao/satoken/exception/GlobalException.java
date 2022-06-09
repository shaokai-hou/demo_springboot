package com.haohao.satoken.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.demo.common.result.ResultCodeEnum;
import com.demo.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haohao
 * @date 2022年06月08日 17:50
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

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
     * 未登录
     */
    @ResponseBody
    @ExceptionHandler(NotLoginException.class)
    public ResultData handlerException() {
        return ResultData.setResult(ResultCodeEnum.NOT_LOGIN);
    }
}
