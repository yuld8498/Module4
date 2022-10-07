package com.example.yuldshop.repository;

import com.example.yuldshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartItemsRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartId(Long cartId);

    Iterable<CartItem> findByProductId(Long id);

    Optional<CartItem> findByProductIdAndUserId(Long productId, Long UserId);

    Iterable<CartItem> findByCheckedIsTrueAndUserId(Long id);

    void deleteByUserIdAndCheckedIsTrue(Long userId);
}
