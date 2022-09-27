package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.Cart;
import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.model.DTO.ListCartItemsDTO;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.cart.ICartService;
import com.example.yuldshop.service.cartItems.ICartItemsService;
import com.example.yuldshop.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ResCartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private ICartItemsService cartItemsService;
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<?> showAllCartOfUser() {
        String username =getUserNamePrincipal();
        if (username == null){
            return new ResponseEntity<>("Empty", HttpStatus.OK);
        }else {
            User user = userService.findByUsername(username).get();
            Cart cart = cartService.findByUserId(user.getId());
            List<CartItem> cartItems = cartItemsService.findByCartId(cart.getId());
            List<ListCartItemsDTO> itemsDTOList = new ArrayList<>();
            for (CartItem cartItem: cartItems){
                itemsDTOList.add(cartItem.toCartDTO());
            }
            return new ResponseEntity<>(itemsDTOList,HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewCartItems(@Validated @RequestBody ListCartItemsDTO cartItemsDTO, BindingResult result){
       if (result.hasFieldErrors()){
           List<ObjectError> list = result.getAllErrors();
           List<String> errorlists = new ArrayList<>();
           for (ObjectError objectError : list){
               errorlists.add(objectError.getDefaultMessage());
           }
           return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
       }
       if (getUserNamePrincipal().isEmpty()){
           return new ResponseEntity<>("/login", HttpStatus.BAD_REQUEST);
       }
       String userName =getUserNamePrincipal();
       User user = userService.findByUsername(userName).get();
       Cart cart ;
       if (cartService.existsCartByUserId(user.getId())){
           cart = cartService.findByUserId(user.getId());
       }else {
           Cart newCart = new Cart();
           newCart.setUser(user);
           newCart.setTotalAmount(new BigDecimal(0));
           newCart.setId(0L);
           cart = cartService.save(newCart);
       }
       CartItem cartItem = cartItemsDTO.toCartItem();
       cartItem.setUserId(user.getId());
       cartItem.setCart(cart);
      CartItem newCartItems =  cartItemsService.save(cartItem);
      return new ResponseEntity<>(newCartItems.toCartDTO(), HttpStatus.OK);
    }


    //get user logging
    public String getUserNamePrincipal(){
        String username =null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }
        return username;
    }

    //check login
    public boolean checkLogin(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            if (!((UserDetails) principal).getUsername().isEmpty()){
                return true;
            }
        }
        return false;
    }
}
