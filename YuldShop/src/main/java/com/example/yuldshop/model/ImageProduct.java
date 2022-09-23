package com.example.yuldshop.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ImageProduct {
    private MultipartFile imageFile;
    private String ImageUrl;
}
