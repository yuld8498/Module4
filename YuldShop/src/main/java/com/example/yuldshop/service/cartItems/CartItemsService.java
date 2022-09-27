package com.example.yuldshop.service.cartItems;

import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.repository.ICartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemsService implements ICartItemsService{
    @Autowired
    private ICartItemsRepository cartItemsRepository;

    @Override
    public Iterable<CartItem> findAll() {
        return cartItemsRepository.findAll();
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemsRepository.findById(id);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public void remove(Long id) {
        cartItemsRepository.deleteById(id);
    }

    @Override
    public List<CartItem> findByCartId(Long cartId) {
        return cartItemsRepository.findByCartId(cartId);
    }
}
