//package com.example.yuldshop.controller.rescontroller;
//
//import com.example.yuldshop.model.DTO.ProductDTO;
//import com.example.yuldshop.model.Product;
//import com.example.yuldshop.service.ProductImgService.IProductImgService;
//import com.example.yuldshop.service.product.IProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/file/img")
//public class imgResController {
//    @Autowired
//    private IProductImgService productImgService;
//    @Autowired
//    private IProductService productService;
//
//    @PostMapping
//    public ResponseEntity<?> uploadImg(@RequestParam("image") MultipartFile file, @RequestParam("data") String data) throws IOException {
//        Product product = productService.findById(Long.valueOf(data)).get();
//        String uploadFile = productImgService.uploadFile(file,product);
//        return new ResponseEntity<>(uploadFile,HttpStatus.OK);
//    }
//
//    @GetMapping({"/{fileName}"})
//    public ResponseEntity<?> dowloadImg(@PathVariable  String fileName){
//      byte[] img =  productImgService.dowloadFile(fileName);
//      return ResponseEntity.status(HttpStatus.OK)
//              .contentType(MediaType.valueOf("image/png"))
//              .body(img);
//    }
//}
