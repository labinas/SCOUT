package com.app.scout.web;/*
    Created by Labina on 01-Mar-22
*/

import com.app.scout.model.response.ImageUploadResponse;
import com.app.scout.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload/user/{userId}")
    public ResponseEntity<ImageUploadResponse> uploadUserImage (@PathVariable Long userId, @RequestParam("file") MultipartFile image){
        String newFileName = imageService.saveProfileImage(userId,image);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/image/download/user/")
                .path(userId.toString())
                .toUriString();

        return ResponseEntity.ok().body(new ImageUploadResponse(newFileName, fileDownloadUri,
                image.getContentType(), image.getSize()));
    }

    @PostMapping("/upload/blog/{blogEntryId}")
    public ResponseEntity<ImageUploadResponse> uploadBlogImage (@PathVariable Long blogEntryId, @RequestParam("file") MultipartFile image){
        String newFileName = imageService.saveBlogImage(blogEntryId,image);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/image/download/blog/")
                .path(blogEntryId.toString())
                .toUriString();

        return ResponseEntity.ok().body(new ImageUploadResponse(newFileName, fileDownloadUri,
                image.getContentType(), image.getSize()));
    }

    @PostMapping("/upload/acc/{accId}")
    public ResponseEntity<List<ImageUploadResponse>> uploadAccImages (@PathVariable Long accId, @RequestParam("files") MultipartFile [] images){
        List<String> filenames = imageService.savePropertyImages(accId,images);
        List<ImageUploadResponse> responses = filenames.stream().map(f -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/download/acc/" + accId.toString() + "/")
                    .path(f)
                    .toUriString();

            return new ImageUploadResponse(f, fileDownloadUri, "img", 0);
        }).collect(Collectors.toList());

        return ResponseEntity.ok().body(responses);
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageUploadResponse> uploadImage (@RequestParam("file") MultipartFile image){
        String newFileName = imageService.saveImage(image);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/image/download/img/")
                .path(newFileName)
                .toUriString();

        return ResponseEntity.ok().body(new ImageUploadResponse(newFileName, fileDownloadUri,
                image.getContentType(), image.getSize()));
    }

    @PostMapping("/uploads")
    public ResponseEntity<List<ImageUploadResponse>> uploadImages (@RequestParam("files") MultipartFile [] images){
        List<String> newFileNames = imageService.saveImages(images);

        List<ImageUploadResponse> responses = newFileNames.stream().map(f -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/download/img/")
                    .path(f)
                    .toUriString();

            return new ImageUploadResponse(f, fileDownloadUri, "img", 0);
        }).collect(Collectors.toList());

        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/download/img/{filename}")
    public ResponseEntity<Resource> downloadImage (@PathVariable String filename, HttpServletRequest request){
        Resource resource = imageService.loadImage(filename);

        return resourceBuilder(resource,request);
    }

    @GetMapping("/download/user/{userId}")
    public ResponseEntity<Resource> downloadUserImage (@PathVariable Long userId, HttpServletRequest request){
        Resource resource = imageService.loadProfileImage(userId);

        return resourceBuilder(resource,request);
    }

    @GetMapping("/download/blog/{blogEntryId}")
    public ResponseEntity<Resource> downloadBlogImage (@PathVariable Long blogEntryId, HttpServletRequest request){
        Resource resource = imageService.loadBlogImage(blogEntryId);

        return resourceBuilder(resource,request);
    }

    @GetMapping("/download/acc/{accId}/{filename}")
    public ResponseEntity<Resource> downloadAccImage (@PathVariable Long accId, @PathVariable String filename, HttpServletRequest request){
        Resource resource = imageService.loadPropertyImage(accId,filename);

        return resourceBuilder(resource,request);
    }

    @GetMapping("/acc/{accId}")
    public ResponseEntity<List<ImageUploadResponse>> getAccImageLinks (@PathVariable Long accId){
        return ResponseEntity.ok().body(imageService.getPropertyImageLinks(accId));
    }

    private ResponseEntity<Resource> resourceBuilder(Resource resource, HttpServletRequest request){
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


}
