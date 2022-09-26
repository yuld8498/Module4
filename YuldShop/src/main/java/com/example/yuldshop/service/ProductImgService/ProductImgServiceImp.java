//package com.example.yuldshop.service.ProductImgService;
//
//import com.example.yuldshop.model.Product;
//import com.example.yuldshop.model.ProductImg;
//import com.example.yuldshop.repository.IProductImgRepository;
//import com.example.yuldshop.untils.ImageUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.transaction.Transactional;
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class ProductImgServiceImp implements IProductImgService {
//
//    @Autowired
//    private IProductImgRepository productImgRepository;
//
//    @Override
//    public String uploadFile(MultipartFile file,Product product) throws IOException {
//        int number = (int) Math.floor(Math.random()*1000000);
//        String fileName = number +"png";
//        ProductImg productImg = productImgRepository.save(ProductImg.builder()
//                .name(fileName)
//                .type(file.getContentType())
//                .product(product)
//                .imgData(ImageUtils.compressImage(file.getBytes())).build());
//        if (productImg != null) {
//            return fileName;
//        }
//        return null;
//    }
//
//    @Override
//    public byte[] dowloadFile(String fileName) {
//        ProductImg productImg = productImgRepository.findByName(fileName);
//       byte[] img =  ImageUtils.decompressImage(productImg.getImgData());
//       return img;
//    }
//
//    @Override
//    public ProductImg findByName(String fileName) {
//        ProductImg productImg =productImgRepository.findByName(fileName);
//        return productImg;
//    }
//}
