package com.haohao.jdbc.template.domain;

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
