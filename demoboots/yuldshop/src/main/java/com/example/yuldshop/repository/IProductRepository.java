package com.example.yuldshop.repository;

import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByDeletedIsFalse();
    List<Product> findByCategoryId(Long id);
    List<Product> findByCategoryIdAndDeletedIsFalse(Long id);
}
