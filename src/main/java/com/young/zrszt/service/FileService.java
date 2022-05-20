package com.young.zrszt.service;

import com.young.zrszt.enums.UploadPathEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 10:50
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return 上传结果
     * @throws IOException;
     */
    String uploadFile(MultipartFile file, UploadPathEnum path) throws IOException;

}
