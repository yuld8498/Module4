package com.example.yuldshop.service.product;

import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.service.IGenericService;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductService extends IGenericService<Product> {
     Iterable<Product> findAllByDeletedIsFalse();
    List<Product> findByCategory(Long id);
}
