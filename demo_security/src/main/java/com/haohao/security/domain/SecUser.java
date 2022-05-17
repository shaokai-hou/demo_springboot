package com.haohao.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表
 *
 * @author haohao
 * @TableName sec_user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
    /**
     * 昵称
     */
    @NotNull(message = "昵称不能为空")
    private String nickname;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态，启用0，禁用1
     */
    private Integer status;

    @TableField(exist = false)
    @NotNull(message = "角色不能为空")
    private List<SecRole> secRoles;
}