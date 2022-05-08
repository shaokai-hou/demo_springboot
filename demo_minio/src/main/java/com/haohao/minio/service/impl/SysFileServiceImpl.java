package com.haohao.minio.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.result.ResultData;
import com.haohao.minio.domain.MinioUploadResult;
import com.haohao.minio.domain.SysFile;
import com.haohao.minio.mapper.SysFileMapper;
import com.haohao.minio.service.MinioService;
import com.haohao.minio.service.SysFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author haohao
 * @description 针对表【sys_file】的数据库操作Service实现
 * @createDate 2022-05-08 12:26:39
 */
@Slf4j
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    @Resource
    private MinioService minioService;

    /**
     * 文件列表
     *
     * @param sysFile sysFile
     * @return ResultData
     */
    @Override
    public ResultData fileList(SysFile sysFile) {
        return ResultData.success().data(this.list(new QueryWrapper<>(sysFile)));
    }

    /**
     * 上传
     *
     * @param file file
     * @return ResultData
     */
    @Override
    public ResultData fileUpload(MultipartFile file) {
        try {
            // 文件路径
            DateTime now = DateUtil.date();
            String filePath = now.year() + File.separator + now.monthBaseOne() + File.separator + now.dayOfMonth() + File.separator;
            // 上传
            MinioUploadResult uploadMap = minioService.upload(file, filePath);
            // 保存记录
            SysFile sysFile = SysFile.builder()
                    .fileOriginalName(file.getOriginalFilename())
                    .fileName(uploadMap.getFileName())
                    .fileUrl(uploadMap.getFileUrl())
                    .filePath(uploadMap.getFinalFileName())
                    .build();
            this.save(sysFile);
            // 返回
            return ResultData.success().data(uploadMap);
        } catch (Exception e) {
            log.error("upload file error", e);
            return ResultData.error();
        }
    }

    /**
     * 文件下载
     *
     * @param response      response
     * @param finalFileName 文件路径名称
     * @return ResultData
     */
    @Override
    public ResultData fileDownload(HttpServletResponse response, String finalFileName) {
        try {
            InputStream inputStream = minioService.download(finalFileName);
            ServletOutputStream outputStream = response.getOutputStream();
            IoUtil.copy(inputStream, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
            response.setCharacterEncoding("UTF-8");
            return ResultData.success();
        } catch (Exception e) {
            log.error("download file error", e);
            return ResultData.error();
        }
    }

    /**
     * 文件删除
     *
     * @param finalFileName 文件路径名称
     * @return ResultData
     */
    @Override
    public ResultData fileDeleteByName(List<String> finalFileName) {
        try {
            minioService.delete(finalFileName);
            return ResultData.success();
        } catch (Exception e) {
            log.error("delete file error", e);
            return ResultData.error();
        }
    }

    /**
     * 文件删除
     *
     * @param ids 文件ID
     * @return ResultData
     */
    @Override
    public ResultData fileDeleteById(List<Long> ids) {
        try {
            List<SysFile> list = this.list(new LambdaQueryWrapper<SysFile>().in(SysFile::getFileId, ids));
            List<String> filePaths = list.stream().map(SysFile::getFilePath).collect(Collectors.toList());
            this.removeBatchByIds(ids);
            minioService.delete(filePaths);
            return ResultData.success();
        } catch (Exception e) {
            log.error("delete file error", e);
            return ResultData.error();
        }
    }
}
