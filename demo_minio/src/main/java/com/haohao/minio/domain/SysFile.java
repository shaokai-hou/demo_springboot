package com.haohao.minio.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haohao
 * @TableName sys_file
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_file")
public class SysFile implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文件主键ID
     */
    @TableId
    private Long fileId;
    /**
     * 文件原名称
     */
    private String fileOriginalName;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件地址
     */
    private String fileUrl;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 业务ID
     */
    private Long serviceId;
    /**
     * 业务名称
     */
    private String serviceName;
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
}