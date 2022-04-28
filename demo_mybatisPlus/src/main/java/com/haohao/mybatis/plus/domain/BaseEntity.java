package com.haohao.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础bean
 *
 * @author haohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

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
    @Version
    private Integer version;
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    @TableField(fill = FieldFill.UPDATE)
    private Integer updater;
    /**
     * 更新时间
     */
    private Date updateTime;
}
