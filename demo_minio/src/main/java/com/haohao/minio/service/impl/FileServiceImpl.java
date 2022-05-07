package com.haohao.minio.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.UUID;
import com.haohao.minio.config.MinioConfig;
import com.haohao.minio.service.IFileService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.messages.DeleteObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haohao
 */
@Service
public class FileServiceImpl implements IFileService {

    @Resource
    private MinioConfig minioConfig;
    @Resource
    private MinioClient minioClient;

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件路径
     * @throws Exception Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        minioClient.putObject(args);
        return minioConfig.getUrl() + File.separator + minioConfig.getBucketName() + File.separator + fileName;
    }

    /**
     * 下载文件
     *
     * @param fileName 文件名称
     * @return InputStream流
     * @throws Exception Exception
     */
    @Override
    public InputStream downloadFile(String fileName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(minioConfig.getBucketName()).object(fileName).build());
    }

    /**
     * 删除文件
     *
     * @param fileName 文件名称
     * @throws Exception 异常
     */
    @Override
    public void deleteFile(String fileName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(minioConfig.getBucketName()).object(fileName).build());
    }

    /**
     * 删除文件
     *
     * @param fileNames 文件名称
     * @throws Exception 异常
     */
    @Override
    public void deleteFile(List<String> fileNames) throws Exception {
        for (String fileName : fileNames) {
            deleteFile(fileName);
        }
    }
}
