package com.example.yuldshop.service.orderItems;

import com.example.yuldshop.model.DTO.OrderItemsDTO;
import com.example.yuldshop.model.OrderItems;
import com.example.yuldshop.service.IGenericService;

import java.util.List;

public interface IOrderItemService extends IGenericService<OrderItems> {
    List<OrderItemsDTO> findOrderItemsDTOByOrderId(Long orderId);

    List<OrderItemsDTO> findAllDTO();
}
