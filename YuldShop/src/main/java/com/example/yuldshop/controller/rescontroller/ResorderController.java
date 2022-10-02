package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.OrderItems;
import com.example.yuldshop.service.order.IOrderService;
import com.example.yuldshop.service.orderItems.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class ResorderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<?>> findAllOrder(){
        List<OrderItems> orderItems = (List<OrderItems>) orderItemService.findAll();
        return new ResponseEntity<>(orderItems,HttpStatus.OK);
    }
    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder(){
        return null;
    }
}
