package com.youtube.jwt.controller;


import com.youtube.jwt.entity.ImageModel;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.StorageService;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }


//    @PostMapping({"/registerNewUser"})
//    public User registerNewUser(@RequestBody User user) {
//        return userService.registerNewUser(user);
//    }
    @PostMapping(value={"/registerNewUser"}, consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public User registerNewUser(@RequestPart("user") User user,
                                @RequestPart("imageFile")MultipartFile[] file) {

        try{
            Set<ImageModel> images= uploadImage(file);
            user.setUserImages(images);
            return userService.registerNewUser(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }



    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModelSet= new HashSet<>();

        for(MultipartFile file: multipartFiles){
            ImageModel imageModel= new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModelSet.add(imageModel);

        }
        return imageModelSet;
    }
















//    @Autowired
//    private StorageService service;
//
//    @PostMapping
//    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
//        String uploadImage = service.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//        byte[] imageData=service.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//
//    }



















    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "Esta URL so esta disponivel para os administradores";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "Esta URL so esta disponivel para  os usuarios";
    }
}
