package com.haohao.jdbc.template.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 系统用户
 *
 * @author haohao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUserEntity extends BaseEntity implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 加密使用的盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 状态，0：禁用，1：启用
     */
    private Integer status;
}
