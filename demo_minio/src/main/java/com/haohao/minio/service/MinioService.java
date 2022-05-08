package com.haohao.minio.service;

import com.haohao.minio.domain.MinioUploadResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * MinioService
 *
 * @author haohao
 */
public interface MinioService {

    /**
     * 上传文件
     *
     * @param file     文件对象
     * @param filePath 文件路径 2022/05/09/
     * @return 文件信息
     * @throws Exception Exception
     */
    MinioUploadResult upload(MultipartFile file, String filePath) throws Exception;

    /**
     * 下载文件
     *
     * @param finalFileName 文件名称路径
     * @return InputStream流
     * @throws Exception Exception
     */
    InputStream download(String finalFileName) throws Exception;

    /**
     * 删除文件
     *
     * @param finalFileName 文件名称路径
     * @throws Exception 异常
     */
    void delete(String finalFileName) throws Exception;

    /**
     * 删除文件
     *
     * @param finalFileNames 文件名称路径
     * @throws Exception 异常
     */
    void delete(List<String> finalFileNames) throws Exception;

}
