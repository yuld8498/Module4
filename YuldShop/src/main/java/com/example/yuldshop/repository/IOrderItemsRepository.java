package com.example.yuldshop.repository;

import com.example.yuldshop.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
