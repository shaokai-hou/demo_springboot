package com.demo.common.result;

import lombok.Getter;

/**
 * 响应枚举类
 *
 * @author haohao
 */
@Getter
public enum ResultCodeEnum {

    /**
     * SUCCESS
     */
    SUCCESS(200, "成功"),
    /**
     * UNKNOWN_ERROR
     */
    UNKNOWN_ERROR(201, "未知错误"),
    /**
     * PARAM_ERROR
     */
    PARAM_ERROR(202, "参数错误"),
    /**
     * NULL_POINT
     */
    NULL_POINT(203, "空指针异常"),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(203, "用户不存在"),
    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未授权"),
    /**
     * 未登录
     */
    NOT_LOGIN(401, "未登录"),
    /**
     * 没有访问权限
     */
    FORBIDDEN(403, "没有访问权限");

    /**
     * 响应状态码
     */
    private final Integer code;
    /**
     * 响应信息
     */
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
