package com.example.adapi.controller;

import com.example.adapi.model.Ad;
import com.example.adapi.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdController {

    @Autowired
    private AdService adService;

    // Create new Ad
    @PostMapping
    public ResponseEntity<Ad> createAd(
         @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("keywords") String keywords,
            @RequestParam(value = "image", required = false) MultipartFile image
    ){
        try {
            String imageUrl = null;

            // ✅ Handle image upload
            if (image != null && !image.isEmpty()) {
                String uploadDir = System.getProperty("user.dir") + "/uploads/";
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String filePath = uploadDir + image.getOriginalFilename();
                image.transferTo(new File(filePath));
                imageUrl = "http://localhost:8081/uploads/" + image.getOriginalFilename();
            }

            // ✅ Create and save Ad object
            Ad ad = new Ad();
            ad.setTitle(title);
            ad.setDescription(description);
            ad.setKeywords(List.of(keywords.split(",")));
            ad.setImageUrl(imageUrl);


        return ResponseEntity.ok(adService.saveAd(ad));
        } catch (Exception e){
            e.printStackTrace(); // 👈 Helpful for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Search Ads by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Ad>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(adService.searchByKeyword(keyword));
    }

    // Upload Image Endpoint
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        try {
            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            String fileUrl = "http://localhost:8081/uploads/" + file.getOriginalFilename(); // Port 8080 for Spring Boot
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
        }
    }
}
