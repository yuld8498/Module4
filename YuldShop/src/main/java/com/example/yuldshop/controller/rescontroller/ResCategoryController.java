package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.DTO.CategoryDTO;
import com.example.yuldshop.model.ProductCategory;
import com.example.yuldshop.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ResCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    ResponseEntity<List<?>> findAllCategory(){
        List<CategoryDTO> list= categoryService.findCategoryToDTO();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?>findById(@PathVariable Long id){
        ProductCategory productCategory = categoryService.findById(id).get();
        CategoryDTO categoryDTO= productCategory.toCategoryDTO();
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?>createCategory(@Validated @RequestBody CategoryDTO categoryDTO, BindingResult result){
        if (result.hasFieldErrors()){
            List<ObjectError> list = result.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list){
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }
        String categoryName = categoryDTO.getCategory();
        if (categoryService.findByName(categoryName)){
            return new ResponseEntity<>("Category is already exists!",HttpStatus.BAD_REQUEST);
        }
        ProductCategory category = categoryDTO.toProductCategory();
        category.setId(null);
        categoryService.save(category);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
