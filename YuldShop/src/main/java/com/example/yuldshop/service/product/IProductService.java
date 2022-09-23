package com.example.yuldshop.service.product;

import com.example.yuldshop.model.DTO.ProductDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.service.IGenericService;

public interface IProductService extends IGenericService<Product> {
    public Iterable<Product> findAllByDeletedIsFalse();
}
