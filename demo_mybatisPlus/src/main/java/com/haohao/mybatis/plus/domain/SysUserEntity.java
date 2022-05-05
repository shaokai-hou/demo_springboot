package com.haohao.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

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
@TableName("sys_user")
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

    /**
     * 状态，0：禁用，1：启用
     */
    @TableField(exist = false)
    private String stateStr;
}
