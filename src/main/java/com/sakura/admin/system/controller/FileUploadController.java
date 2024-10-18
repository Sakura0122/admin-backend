package com.sakura.admin.system.controller;

import com.sakura.admin.common.Result;
import com.sakura.admin.system.service.FileUploadService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: sakura
 * @date: 2024/10/12 13:31
 * @description:
 */
@RestController
@RequestMapping("/admin/upload")
@Tag(name = "文件上传")
public class FileUploadController {

    @Resource
    private FileUploadService fileUploadService;

    @RequestMapping()
    @Schema(description = "文件上传")
    public Result<String> upload(@RequestParam("file") MultipartFile multipartFile) {
        return Result.success(fileUploadService.upload(multipartFile));
    }
}
