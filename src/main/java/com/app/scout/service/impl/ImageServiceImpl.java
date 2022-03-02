package com.app.scout.service.impl;/*
    Created by Labina on 01-Mar-22
*/

import com.app.scout.model.Accommodation;
import com.app.scout.model.AccommodationPhoto;
import com.app.scout.model.AppUser;
import com.app.scout.model.BlogEntry;
import com.app.scout.model.exceptions.FileIsEmptyException;
import com.app.scout.model.exceptions.FileNotFoundException;
import com.app.scout.model.exceptions.FileStorageException;
import com.app.scout.model.response.ImageUploadResponse;
import com.app.scout.service.AccommodationService;
import com.app.scout.service.AppUserService;
import com.app.scout.service.BlogEntryService;
import com.app.scout.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final Path root = Paths.get("uploads");
    private final Path userPath = Paths.get("uploads/profile");
    private final Path accPath = Paths.get("uploads/property");
    private final Path blogPath = Paths.get("uploads/blog");

    private final AppUserService userService;
    private final AccommodationService accommodationService;
    private final BlogEntryService blogService;

    @Override
    @PostConstruct
    public void init() {
        try {
            if(!Files.exists(root))
                Files.createDirectory(root);
            if(!Files.exists(userPath))
                Files.createDirectory(userPath);
            if(!Files.exists(accPath))
                Files.createDirectory(accPath);
            if(!Files.exists(blogPath))
                Files.createDirectory(blogPath);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize folder for upload!");
        }
    }

    @Override
    public String saveImage(MultipartFile image) {
        if(image == null || image.isEmpty())
            throw new FileIsEmptyException("There is no file sent!");

        try {
            Path targetLocation = this.root.resolve(image.getOriginalFilename());
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileStorageException("Could not store the file. Error: " + e.getMessage());
        }

        return image.getOriginalFilename();
    }

    @Override
    public List<String> saveImages(MultipartFile[] images) {
        if(images.length == 0)
            throw new FileIsEmptyException("No images sent!");

        return Arrays.stream(images).map(this::saveImage).collect(Collectors.toList());
    }

    @Override
    public Resource loadImage(String filename) {
        try {
            Path filePath = this.root.resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + filename);
        }
    }

    @Override
    public String saveProfileImage(Long id, MultipartFile image) {
        Path userFolder = this.userPath.resolve(id.toString());
        try {
            if(!Files.exists(userFolder))
                Files.createDirectory(userFolder);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize folder for upload!");
        }

        if(image == null || image.isEmpty())
            throw new FileIsEmptyException("There is no file sent!");

        AppUser user = userService.findById(id).orElse(null);
        if(user == null)
            throw new FileStorageException("Could not store the file because the user does not exist.");

        try {
            String newFileName = "profile_image_" + id + "." + image.getOriginalFilename().split("\\.")[1];
            Path targetLocation = userFolder.resolve(newFileName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            user.setImgPath(targetLocation.toString());
            userService.save(user);

            return newFileName;
        } catch (Exception e) {
            throw new FileStorageException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public String saveBlogImage(Long id, MultipartFile image) {
        Path userFolder = this.blogPath.resolve(id.toString());
        try {
            if(!Files.exists(userFolder))
                Files.createDirectory(userFolder);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize folder for upload!");
        }

        if(image == null || image.isEmpty())
            throw new FileIsEmptyException("There is no file sent!");

        BlogEntry blogEntry = blogService.findById(id).orElse(null);
        if(blogEntry == null)
            throw new FileStorageException("Could not store the file because the blog entry does not exist.");

        try {
            String newFileName = "blog_image_" + id + "." + image.getOriginalFilename().split("\\.")[1];
            Path targetLocation = userFolder.resolve(newFileName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            blogEntry.setImgPath(targetLocation.toString());
            blogService.save(blogEntry);

            return newFileName;

        } catch (Exception e) {
            throw new FileStorageException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public String savePropertyImage(Long id, int i, boolean cover, MultipartFile image) {
        Path userFolder = this.accPath.resolve(id.toString());
        try {
            if(!Files.exists(userFolder))
                Files.createDirectory(userFolder);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize folder for upload!");
        }

        if(image == null || image.isEmpty())
            throw new FileIsEmptyException("There is no file sent!");

        Accommodation accommodation = accommodationService.findById(id).orElse(null);
        if(accommodation == null)
            throw new FileStorageException("Could not store the file because the accommodation does not exist.");

        try {
            String newFileName = cover ? "cover." + image.getOriginalFilename().split("\\.")[1] : "acc_image_" + i + "." + image.getOriginalFilename().split("\\.")[1];
            Path targetLocation = userFolder.resolve(newFileName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            accommodation.getPhotos().add(new AccommodationPhoto(cover,newFileName));
            accommodationService.save(accommodation);

            return newFileName;

        } catch (Exception e) {
            throw new FileStorageException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public List<String> savePropertyImages(Long id, MultipartFile[] images) {
        List<String> response = new LinkedList<>();

        for(int i = 0; i < images.length; i++){
            if(i == 0){
                response.add(savePropertyImage(id, i, true, images[i]));
            }
            else response.add(savePropertyImage(id, i, false, images[i]));
        }
        return response;
    }

    @Override
    public Resource loadProfileImage(Long id) {
        AppUser user = userService.findById(id).orElse(null);
        if(user == null)
            throw new FileStorageException("Could not load the file because the user does not exist.");

        try {
            Path filePath = Paths.get(user.getImgPath());
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found.");
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found.");
        }
    }

    @Override
    public Resource loadBlogImage(Long id) {
        BlogEntry blogEntry = blogService.findById(id).orElse(null);
        if(blogEntry == null)
            throw new FileStorageException("Could not load the file because the blog entry does not exist.");

        try {
            Path filePath = Paths.get(blogEntry.getImgPath());
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found.");
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found.");
        }

    }

    @Override
    public Resource loadPropertyImage(Long id, String filename) {
        Accommodation accommodation = accommodationService.findById(id).orElse(null);
        if(accommodation == null)
            throw new FileStorageException("Could not load the file because the accommodation does not exist.");

        try {
            Path filePath = Paths.get("uploads/property/" + id + "/" + filename);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found.");
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found.");
        }
    }

    @Override
    public List<ImageUploadResponse> getPropertyImageLinks(Long id) {
        Accommodation accommodation = accommodationService.findById(id).orElse(null);
        if(accommodation == null)
            throw new FileStorageException("Could not find the links because the accommodation does not exist.");

        return accommodation.getPhotos().stream().map(p -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/download/acc/" + id.toString() + "/")
                    .path(p.getImgPath())
                    .toUriString();

            return new ImageUploadResponse(p.getImgPath(), fileDownloadUri, "img", 0);
        }).collect(Collectors.toList());

    }

    @Override
    public String getPropertyCoverLink(Long id) {
        Accommodation accommodation = accommodationService.findById(id).orElse(null);
        if(accommodation == null)
            throw new FileStorageException("Could not find the file because the accommodation does not exist.");

        AccommodationPhoto cover = accommodation.getPhotos().stream().findFirst().orElseThrow(() -> new FileNotFoundException("Cover does not exist!"));

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/image/download/acc/" + id.toString() + "/")
                .path(cover.getImgPath())
                .toUriString();
    }
}
