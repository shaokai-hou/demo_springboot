package com.haohao.minio.controller;

import com.demo.common.result.ResultData;
import com.haohao.minio.domain.SysFile;
import com.haohao.minio.service.SysFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/file")
public class SysFileController {

    @Resource
    private SysFileService sysFileService;

    @GetMapping("/list")
    public ResultData fileList(SysFile sysFile) {
        return sysFileService.fileList(sysFile);
    }

    @PostMapping("/upload")
    public ResultData fileUpload(MultipartFile file) {
        return sysFileService.fileUpload(file);
    }

    @GetMapping("/download")
    public ResultData downloadFile(HttpServletResponse response, String fileName) {
        return sysFileService.fileDownload(response, fileName);
    }

    @DeleteMapping("/name")
    public ResultData deleteFile(@RequestParam("files") String[] fileNames) {
        return sysFileService.fileDeleteByName(Arrays.asList(fileNames));
    }

    @DeleteMapping("/id")
    public ResultData deleteFile(@RequestParam("files") Long[] ids) {
        return sysFileService.fileDeleteById(Arrays.asList(ids));
    }
}
