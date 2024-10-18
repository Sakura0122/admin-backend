package com.sakura.admin.system.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: sakura
 * @date: 2024/10/12 13:32
 * @description:
 */
public interface FileUploadService {

    /**
     * 文件上传
     * @param multipartFile 文件
     * @return 文件地址
     */
    String upload(MultipartFile multipartFile);
}
