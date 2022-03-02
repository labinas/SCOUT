package com.app.scout.service;/*
    Created by Labina on 01-Mar-22
*/


import com.app.scout.model.response.ImageUploadResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    void init();
    String saveImage(MultipartFile image);
    List<String> saveImages(MultipartFile [] images);
    Resource loadImage(String filename);
    String saveProfileImage (Long id, MultipartFile image);
    String saveBlogImage (Long id, MultipartFile image);
    String savePropertyImage (Long id, int i, boolean cover, MultipartFile image);
    List<String> savePropertyImages (Long id, MultipartFile [] images);
    Resource loadProfileImage (Long id);
    Resource loadBlogImage (Long id);
    Resource loadPropertyImage (Long id, String filename);
    List<ImageUploadResponse> getPropertyImageLinks (Long id);
    String getPropertyCoverLink (Long id);

}
