package com.haohao.security.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 角色权限关系表
 * @author haohao
 * @TableName sec_role_permission
 */
@Data
public class SecRolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 角色主键
     */
    private Long roleId;
    /**
     * 权限主键
     */
    private Long permissionId;

}