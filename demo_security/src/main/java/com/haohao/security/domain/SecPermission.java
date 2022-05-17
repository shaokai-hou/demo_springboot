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
     * 父级id
     */
    private Long parentId;
    /**
     * 权限表达式
     */
    private String permission;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 排序
     */
    private Integer sort;
}