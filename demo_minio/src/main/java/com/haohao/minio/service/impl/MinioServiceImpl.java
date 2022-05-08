package com.haohao.minio.service.impl;

import cn.hutool.core.util.IdUtil;
import com.haohao.minio.config.MinioConfig;
import com.haohao.minio.domain.MinioUploadResult;
import com.haohao.minio.service.MinioService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haohao
 */
@Service
public class MinioServiceImpl implements MinioService {

    @Resource
    private MinioConfig minioConfig;
    @Resource
    private MinioClient minioClient;

    /**
     * 上传文件
     *
     * @param file     文件对象
     * @param filePath 文件路径 2022/05/09/
     * @return 文件信息
     * @throws Exception Exception
     */
    @Override
    public MinioUploadResult upload(MultipartFile file, String filePath) throws Exception {
        Map<String, String> result = new HashMap<>(3);
        // 处理文件名称
        String fileName = this.handleFileName(file);
        // 创建目录
        createDir(minioConfig.getBucketName(), filePath);
        // 最终路径名称
        String finalFileName = filePath + fileName;
        // 构建参数、上传
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(finalFileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        // 上传
        minioClient.putObject(args);
        // 下载Url
        String fileUrl = minioConfig.getUrl() + File.separator + minioConfig.getBucketName() + File.separator + finalFileName;
        // 返回结果
        return MinioUploadResult.builder().fileName(fileName).fileUrl(fileUrl).finalFileName(finalFileName).build();
    }

    /**
     * 下载文件
     *
     * @param finalFileName 文件名称路径
     * @return InputStream流
     * @throws Exception Exception
     */
    @Override
    public InputStream download(String finalFileName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(minioConfig.getBucketName()).object(finalFileName).build());
    }

    /**
     * 删除文件
     *
     * @param finalFileName 文件名称路径
     * @throws Exception 异常
     */
    @Override
    public void delete(String finalFileName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(minioConfig.getBucketName()).object(finalFileName).build());
    }

    /**
     * 删除文件
     *
     * @param finalFileNames 文件名称路径
     * @throws Exception 异常
     */
    @Override
    public void delete(List<String> finalFileNames) throws Exception {
        for (String fileName : finalFileNames) {
            delete(fileName);
        }
    }

    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶
     * @param objectName 目录路径
     */
    public void createDir(String bucketName, String objectName) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
                        .build());
    }

    /**
     * @param file file
     * @return 文件名称
     */
    private String handleFileName(MultipartFile file) {
        // 获取文件名
        String name = file.getOriginalFilename();
        // 获取文件名称、文件后缀
        assert name != null;
        return IdUtil.simpleUUID() + name.substring(name.lastIndexOf("."));
    }
}
