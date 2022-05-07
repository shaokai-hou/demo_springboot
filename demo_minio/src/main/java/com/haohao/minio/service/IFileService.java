package com.haohao.minio.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author haohao
 */
public interface IFileService {

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件路径
     * @throws Exception Exception
     */
    String uploadFile(MultipartFile file) throws Exception;

    /**
     * 下载文件
     *
     * @param fileName 文件名称
     * @return InputStream流
     * @throws Exception Exception
     */
    InputStream downloadFile(String fileName) throws Exception;

    /**
     * 删除文件
     *
     * @param fileName 文件名称
     * @throws Exception 异常
     */
    void deleteFile(String fileName) throws Exception;

    /**
     * 删除文件
     *
     * @param fileNames 文件名称
     * @throws Exception 异常
     */
    void deleteFile(List<String> fileNames) throws Exception;


}
