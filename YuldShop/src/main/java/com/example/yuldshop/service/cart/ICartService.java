package com.example.yuldshop.service.cart;

import com.example.yuldshop.model.Cart;
import com.example.yuldshop.service.IGenericService;

public interface ICartService extends IGenericService<Cart> {
    Cart findByUserId(Long userId);
    boolean existsCartByUserId(Long userId);
}
