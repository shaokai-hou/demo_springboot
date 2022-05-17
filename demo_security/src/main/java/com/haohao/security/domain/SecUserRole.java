package com.haohao.security.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色关系表
 *
 * @author haohao
 * @TableName sec_user_role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 角色主键
     */
    private Long roleId;
}