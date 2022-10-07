package com.example.yuldshop.service.order;

import com.example.yuldshop.model.Order;
import com.example.yuldshop.service.IGenericService;

import java.util.List;
import java.util.Optional;

public interface IOrderService extends IGenericService<Order> {
    Optional<Order> findByCustomerId(Long customerId);

}
