package com.example.yuldshop.repository;

import com.example.yuldshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
    boolean existsByUserId(Long userId);
}
