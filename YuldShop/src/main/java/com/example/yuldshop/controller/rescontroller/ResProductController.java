package com.example.yuldshop.controller.rescontroller;

import com.cloudinary.Cloudinary;
import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.service.cartItems.ICartItemsService;
import com.example.yuldshop.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.awt.print.Pageable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ResProductController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartItemsService cartItemsService;

    @GetMapping
    public ResponseEntity<List<?>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAllByDeletedIsFalse();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(product.toProductDTO());
        }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        ProductDTO productDTO = product.toProductDTO();
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> findProductByCategories(@PathVariable Long id) {
        List<Product> products = productService.findByCategory(id);
       List<ProductDTO> productDTOS = new ArrayList<>();
       for (Product product:products){
           productDTOS.add(product.toProductDTO());
       }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@Validated @RequestBody ProductDTO productDTO, BindingResult result) {
        if (result.hasFieldErrors()) {
            List<ObjectError> list = result.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list) {
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }
        Product product = productDTO.toProduct();
        Product newProduct = productService.save(product);
        ProductDTO newProductDTO = newProduct.toProductDTO();
        return new ResponseEntity<>(newProductDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,
                                           @Validated @RequestBody ProductDTO productDTO, BindingResult result) {
        if (result.hasFieldErrors()) {
            List<ObjectError> list = result.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list) {
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }
        Product product = productService.findById(id).get();
        Long productId = product.getId();
        Product newProduct = productDTO.toProduct();
        List<CartItem> cartItemList = (List<CartItem>) cartItemsService.findByProductId(productId);
        for (CartItem cartItem:cartItemList){
            cartItem.setPrice(newProduct.getPrice());
            cartItemsService.save(cartItem);
        }
        newProduct.setId(productId);
        productService.save(newProduct);
        return new ResponseEntity<>(newProduct.toProductDTO(), HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        product.setDeleted(true);
        productService.save(product);
        ProductDTO productDTO = product.toProductDTO();
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
