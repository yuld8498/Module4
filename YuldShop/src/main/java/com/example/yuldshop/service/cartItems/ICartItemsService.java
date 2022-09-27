package com.example.yuldshop.service.cartItems;

import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.service.IGenericService;

import java.util.List;

public interface ICartItemsService extends IGenericService<CartItem> {
    List<CartItem> findByCartId(Long cartId);
}
