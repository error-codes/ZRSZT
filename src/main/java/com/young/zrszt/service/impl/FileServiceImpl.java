package com.young.zrszt.service.impl;

import com.young.zrszt.enums.UploadPath;
import com.young.zrszt.service.FileService;
import com.young.zrszt.util.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 10:59
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Value("${zrszt.upload.image.url}")
    private String fileUrl;

    @Value("${zrszt.upload.host}")
    private String host;

    @Override
    public String uploadFile(MultipartFile file, UploadPath path) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("文件不能为空");
        }
        String originalFilename = file.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = SnowFlakeUtils.getSnowFlakeId() + suffixName;
        file.transferTo(new File(fileUrl + fileName));
        return host + path.getPath() + fileName;
    }
}
