package com.example.yuldshop.service.category;

import com.example.yuldshop.model.DTO.CategoryDTO;
import com.example.yuldshop.model.ProductCategory;
import com.example.yuldshop.service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<ProductCategory> {
    List<CategoryDTO> findCategoryToDTO();
    boolean findByName(String category);
}
