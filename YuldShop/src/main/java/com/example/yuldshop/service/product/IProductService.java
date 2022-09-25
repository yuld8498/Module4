package com.example.yuldshop.service.product;

import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.service.IGenericService;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IProductService extends IGenericService<Product> {
    public Iterable<Product> findAllByDeletedIsFalse();
}
