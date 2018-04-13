package com.cxy.background.controller;

import com.cxy.background.entity.Product;
import com.cxy.background.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("uploadImage")
    public String uploadImage(MultipartFile file){


        return imageService.uploadImage(file);
    }
}
