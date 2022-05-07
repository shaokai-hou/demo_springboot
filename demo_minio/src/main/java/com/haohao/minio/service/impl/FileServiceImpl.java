package com.haohao.minio.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.haohao.minio.config.MinioConfig;
import com.haohao.minio.service.IFileService;
import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
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
        // 获取文件名
        String name = file.getOriginalFilename();
        // 获取文件名称、文件后缀
        assert name != null;
        String prefix = name.substring(name.lastIndexOf("."));
        // 获取年月日
        int year = DateUtil.date().year();
        int month = DateUtil.date().monthBaseOne();
        int day = DateUtil.date().dayOfMonth();
        year = 2021;
        day = 9;
        // 获取基础路径
        String basePath = year + "年" + File.separator + month + "月" + File.separator + day + "日" + File.separator;
        // 创建目录
        createDir(minioConfig.getBucketName(), basePath);
        // 生产随机名称
        String fileName = basePath + IdUtil.simpleUUID() + prefix;
        // 构建参数、上传
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

    /**
     * 判断Bucket是否存在
     *
     * @return true：存在，false：不存在
     * @throws Exception Exception
     */
    private boolean isBucket(String bucketName) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 获得所有Bucket列表
     *
     * @return Bucket列表
     * @throws Exception Exception
     */
    public List<Bucket> getBuckets() throws Exception {
        return minioClient.listBuckets();
    }

    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶
     * @param objectName 目录路径
     */
    public ObjectWriteResponse createDir(String bucketName, String objectName) throws Exception {
        return minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
                        .build());
    }
}
