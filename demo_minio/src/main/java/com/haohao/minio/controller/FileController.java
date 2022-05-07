package com.haohao.minio.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.haohao.minio.service.IFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private IFileService fileService;

    @PostMapping("/upload")
    public String fileUpload(MultipartFile file) throws Exception {
        return fileService.uploadFile(file);
    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response, String fileName) throws Exception {
        InputStream inputStream = fileService.downloadFile(fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        IoUtil.copy(inputStream, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
        response.setCharacterEncoding("UTF-8");
    }

    @DeleteMapping("/{fileNames}")
    public void deleteFile(@PathVariable("fileNames") List<String> fileNames) throws Exception {
        fileService.deleteFile(fileNames);
    }
}
