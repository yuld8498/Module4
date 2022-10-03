package com.example.yuldshop.service.order;

import com.example.yuldshop.model.DTO.OrderItemsDTO;
import com.example.yuldshop.model.Order;
import com.example.yuldshop.repository.IOrderItemsRepository;
import com.example.yuldshop.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImp implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {

    }
    @Override
    public Optional<Order> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

}
