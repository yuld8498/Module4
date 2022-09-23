package com.example.yuldshop.service.category;

import com.example.yuldshop.model.DTO.CategoryDTO;
import com.example.yuldshop.model.ProductCategory;
import com.example.yuldshop.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService  implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }

    @Override
    public void remove(Long id) {
        ProductCategory productCategory =categoryRepository.findById(id).get();
      productCategory.setDeleted(true);
      categoryRepository.save(productCategory);
    }

    @Override
    public List<CategoryDTO> findCategoryToDTO() {
        return categoryRepository.findAllByDeletedIsFalse();
    }

    @Override
    public boolean findByName(String category) {
        return categoryRepository.existsByCategory(category);
    }
}
