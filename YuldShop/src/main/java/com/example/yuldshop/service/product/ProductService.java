package com.example.yuldshop.service.product;

import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Product> findAllByDeletedIsFalse() {
        return productRepository.findAllByDeletedIsFalse();
    }

    @Override
    public List<Product> findByCategory(Long id) {
        return productRepository.findByCategoryIdAndDeletedIsFalse(id);
    }
}
