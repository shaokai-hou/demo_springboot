package com.haohao.webflux.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author haohao
 */
@Data
@Table("sys_user")
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @Id
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
     * 状态 0：启用，1：禁用
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除 0：未删除 1：已删除
     */
    private Integer deleted;
    /**
     * 乐观锁
     */
    private Integer version;
    /**
     * 创建者
     */
    private Integer creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private Integer updater;
    /**
     * 更新时间
     */
    private Date updateTime;
    private static final long serialVersionUID = 1L;
}