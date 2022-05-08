package com.haohao.minio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.result.ResultData;
import com.haohao.minio.domain.SysFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author haohao
 * @description 针对表【sys_file】的数据库操作Service
 * @createDate 2022-05-08 12:26:39
 */
public interface SysFileService extends IService<SysFile> {

    /**
     * 文件列表
     *
     * @param sysFile sysFile
     * @return ResultData
     */
    ResultData fileList(SysFile sysFile);

    /**
     * 上传
     *
     * @param file file
     * @return ResultData
     */
    ResultData fileUpload(MultipartFile file);

    /**
     * 文件下载
     *
     * @param response      response
     * @param finalFileName 文件路径名称
     * @return ResultData
     */
    ResultData fileDownload(HttpServletResponse response, String finalFileName);

    /**
     * 文件删除
     *
     * @param finalFileName 文件路径名称
     * @return ResultData
     */
    ResultData fileDeleteByName(List<String> finalFileName);

    /**
     * 文件删除
     *
     * @param ids 文件ID
     * @return ResultData
     */
    ResultData fileDeleteById(List<Long> ids);
}
