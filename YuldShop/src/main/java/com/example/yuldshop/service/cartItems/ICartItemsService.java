package com.example.yuldshop.service.cartItems;

import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.service.IGenericService;

import java.util.List;
import java.util.Optional;

public interface ICartItemsService extends IGenericService<CartItem> {
    List<CartItem> findByCartId(Long cartId);

    Iterable<CartItem> findByProductId(Long id);

    Optional<CartItem> findByProductIdAndUserId(Long productId, Long userId);

    Iterable<CartItem> findByCheckedIsTrue(Long userId);

    void deletedByUserIdAndCheckIsTrue(Long userId);
}
