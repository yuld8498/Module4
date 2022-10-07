package com.example.yuldshop.service.cart;

import com.example.yuldshop.model.Cart;
import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.service.IGenericService;

import java.util.Optional;

public interface ICartService extends IGenericService<Cart> {
    Optional<Cart> findByUserId(Long userId);
    boolean existsCartByUserId(Long userId);
}
