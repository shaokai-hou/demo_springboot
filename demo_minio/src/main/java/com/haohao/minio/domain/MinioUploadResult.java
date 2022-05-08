package com.haohao.minio.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author haohao
 */
@Data
@Builder
public class MinioUploadResult {

    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件名称路径
     */
    private String finalFileName;
    /**
     * 文件下载地址
     */
    private String fileUrl;
}
