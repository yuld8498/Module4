package com.example.yuldshop.service.orderItems;

import com.example.yuldshop.model.DTO.OrderItemsDTO;
import com.example.yuldshop.model.OrderItems;
import com.example.yuldshop.repository.IOrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderItemServiceImp implements IOrderItemService{
    @Autowired
    private IOrderItemsRepository orderItemsRepository;
    @Override
    public Iterable<OrderItems> findAll() {
        return orderItemsRepository.findAll();
    }

    @Override
    public Optional<OrderItems> findById(Long id) {
        return orderItemsRepository.findById(id);
    }

    @Override
    public OrderItems save(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<OrderItemsDTO> findOrderItemsDTOByOrderId(Long orderId) {
        return orderItemsRepository.findAllOrderDTOByOrderId(orderId);
    }

    @Override
    public List<OrderItemsDTO> findAllDTO() {
        return orderItemsRepository.findAllOrderDTO();
    }
}
