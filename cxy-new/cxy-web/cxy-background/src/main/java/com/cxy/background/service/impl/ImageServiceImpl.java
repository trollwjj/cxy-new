package com.cxy.background.service.impl;

import com.cxy.background.service.ImageService;
import com.cxy.background.utils.FastDFSUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${IMAGE_SERVER_BASE_PATH}")
    private String IMAGE_SERVER_BASE_PATH;

    @Override
    public String uploadImage(MultipartFile file) {

        String originalFilename = file.getOriginalFilename(); //eg:123.jpg
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);

        try {
            FastDFSUtils fastDFSUtils = new FastDFSUtils("classpath:properties/fastdfs.properties");

            String path = fastDFSUtils.uploadFile(file.getBytes(), ext);
            System.out.println(path);
            return  new  StringBuilder().append(IMAGE_SERVER_BASE_PATH).append(File.separator).append(path).toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return null;
    }
}
