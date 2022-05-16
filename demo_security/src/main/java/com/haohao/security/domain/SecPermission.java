package com.haohao.security.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 权限表
 * @author haohao
 * @TableName sec_permission
 */
@Data
public class SecPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
    private String url;
    /**
     * 权限类型，页面-1，按钮-2
     */
    private Integer type;
    /**
     * 权限表达式
     */
    private String permission;
    /**
     * 后端接口访问方式
     */
    private String method;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父级id
     */
    private Long parentId;
}