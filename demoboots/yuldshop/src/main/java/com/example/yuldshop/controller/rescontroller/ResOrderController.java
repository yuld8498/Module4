package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.*;
import com.example.yuldshop.model.DTO.OrderItemsDTO;
import com.example.yuldshop.service.cart.ICartService;
import com.example.yuldshop.service.cartItems.ICartItemsService;
import com.example.yuldshop.service.customer.ICustomerService;
import com.example.yuldshop.service.order.IOrderService;
import com.example.yuldshop.service.orderItems.IOrderItemService;
import com.example.yuldshop.service.product.IProductService;
import com.example.yuldshop.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderItems")
public class ResOrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private ICartItemsService cartItemsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<?>> findAllOrder() {
        List<OrderItemsDTO> orderItemsDTOS = orderItemService.findAllDTO();
        for (OrderItemsDTO orderItemsDTO : orderItemsDTOS){
            Product product =productService.findById(orderItemsDTO.getProductId()).get();
            orderItemsDTO.setProductName(product.getProductName());
        }
        return new ResponseEntity<>(orderItemsDTOS,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<?>> findOrderById(@PathVariable Long id) {
        List<OrderItemsDTO> orderItemsDTOS = orderItemService.findOrderItemsDTOByOrderId(id);
        return new ResponseEntity<>(orderItemsDTOS, HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder() {
        Order order = new Order();
        User user = userService.findByUsername(getUserNamePrincipal()).get();
        Customer customer = customerService.findByUser(user);
        Optional<Cart> cartOptional = cartService.findByUserId(user.getId());
        List<CartItem> cartItemList = (List<CartItem>) cartItemsService.findByCheckedIsTrue(user.getId());
        //check cart
        if (!cartOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cart cart = cartOptional.get();
        //check customer
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
        }
        if (cartItemList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
//        //check order
//        //chưa có order
        order.setCustomer(customer);
        order.setTotal(cart.getTotalAmount());
        order.setId(0L);
        Order newOrder = orderService.save(order);
        for (CartItem cartItem : cartItemList) {
            OrderItems orderItems = new OrderItems();
            Product product = productService.findById(cartItem.getProductId()).get();
            orderItems.setOrder(newOrder)
                    .setQuantity(cartItem.getQuantity())
                    .setPrice(product.getPrice())
                    .setId(0L)
                    .setProductId(cartItem.getProductId());
            orderItemService.save(orderItems);
        }
        cart.setTotalAmount(new BigDecimal(0));
        cartService.save(cart);
        cartItemsService.deletedByUserIdAndCheckIsTrue(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //principal
    public String getUserNamePrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        return username;
    }
}
