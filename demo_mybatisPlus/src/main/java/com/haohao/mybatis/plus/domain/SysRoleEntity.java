package com.haohao.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 系统角色
 *
 * @author haohao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;
}
