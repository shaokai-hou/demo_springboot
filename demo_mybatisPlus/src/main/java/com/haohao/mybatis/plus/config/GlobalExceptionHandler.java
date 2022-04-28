package com.haohao.mybatis.plus.config;

import com.haohao.mybatis.plus.domain.result.ResultCodeEnum;
import com.haohao.mybatis.plus.domain.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 指定异常处理方法
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultData error(NullPointerException e) {
        log.error("空指针异常信息", e);
        return ResultData.setResult(ResultCodeEnum.NULL_POINT);
    }
}
