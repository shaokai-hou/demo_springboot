package com.haohao.security.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {

    /**
     * 状态嘛
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;
}
