package com.example.yuldshop.repository;

import com.example.yuldshop.model.DTO.CategoryDTO;
import com.example.yuldshop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<ProductCategory, Long> {
    @Query("SELECT NEW com.example.yuldshop.model.DTO.CategoryDTO (c.id, c.category) FROM ProductCategory  AS c WHERE c.deleted= false")
    List<CategoryDTO> findAllByDeletedIsFalse();
    boolean existsByCategory(String category);
}
