package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.Cart;
import com.example.yuldshop.model.CartItem;
import com.example.yuldshop.model.DTO.ListCartItemsDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.cart.ICartService;
import com.example.yuldshop.service.cartItems.ICartItemsService;
import com.example.yuldshop.service.product.IProductService;
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
import java.util.*;

@RestController
@RequestMapping("/api/carts")
public class ResCartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private ICartItemsService cartItemsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<?>> showAllCart() {
        List<CartItem> cartItemList = (List<CartItem>) cartItemsService.findAll();
        List<ListCartItemsDTO> listCartItemsDTOS = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            listCartItemsDTOS.add(cartItem.toCartDTO());
        }
        return new ResponseEntity<>(listCartItemsDTOS, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<?>> findAllCartOfUser() {
        String userName = getUserNamePrincipal();
        Optional<Cart> cart = cartService.findByUserId(userService.findByUsername(userName).get().getId());
        List<CartItem> cartItems;
        if (cart.isPresent()) {
            cartItems = cartItemsService.findByCartId(cart.get().getId());
            List<ListCartItemsDTO> listCartItemsDTOS = new ArrayList<>();
            for (CartItem c : cartItems) {
                listCartItemsDTOS.add(c.toCartDTO());
            }
            return new ResponseEntity<>(listCartItemsDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //add quantity cart
    @GetMapping("/add/{id}")
    public ResponseEntity<?> AddQuantity(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemsService.findById(id);
        Product product = productService.findById(cartItem.get().getProductId()).get();
        String userName = getUserNamePrincipal();
        User user = userService.findByUsername(userName).get();
        Long userId = user.getId();
        Long userIdCart = cartItem.get().getUserId();
        if (userId.equals(userIdCart)) {
            CartItem newCartItems = cartItem.get();
            int oldQuantity = newCartItems.getQuantity();
            newCartItems.setQuantity(oldQuantity + 1);
            newCartItems.setAmount(product.getPrice().multiply(new BigDecimal(newCartItems.getQuantity())));
            CartItem resCartItems = cartItemsService.save(newCartItems);
            Cart cart = cartService.findByUserId(user.getId()).get();
            cart.setTotalAmount(getTotalAmount());
            cartService.save(cart);
            return new ResponseEntity<>(resCartItems.toCartDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //minus quantity cart
    @GetMapping("/minus/{id}")
    public ResponseEntity<?> MinusQuantity(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemsService.findById(id);
        Product product = productService.findById(cartItem.get().getProductId()).get();
        String userName = getUserNamePrincipal();
        User user = userService.findByUsername(userName).get();
        Long userId = user.getId();
        Long userIdCart = cartItem.get().getUserId();
        if (userId.equals(userIdCart)) {
            CartItem newCartItems = cartItem.get();
            int oldQuantity = newCartItems.getQuantity();
            newCartItems.setQuantity(oldQuantity - 1);
            newCartItems.setAmount(product.getPrice().multiply(new BigDecimal(newCartItems.getQuantity())));
            CartItem resCartItems = cartItemsService.save(newCartItems);
            Cart cart = cartService.findByUserId(user.getId()).get();
            cart.setTotalAmount(getTotalAmount());
            cartService.save(cart);
            return new ResponseEntity<>(resCartItems.toCartDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/input/{id}")
    public ResponseEntity<?> SetQuantityByCart(@PathVariable Long id, @RequestBody ListCartItemsDTO cartItemsDTO) {
        Optional<CartItem> cartItem = cartItemsService.findById(id);
        Product product = productService.findById(cartItem.get().getProductId()).get();
        Map<String, Integer> map = new HashMap<>();
        if (cartItemsDTO.getQuantity() <= 0) {
            map.put("can't order in quantity of 0 !", cartItem.get().getQuantity());
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if (cartItemsDTO.getQuantity() >= 100) {
            map.put("You can only order less than 100 unit of 1 product in 1 purchase", cartItem.get().getQuantity());
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        String userName = getUserNamePrincipal();
        User user = userService.findByUsername(userName).get();
        Long userId = user.getId();
        Long userIdCart = cartItem.get().getUserId();
        if (userId.equals(userIdCart)) {
            CartItem newCartItems = cartItem.get();
            newCartItems.setQuantity(cartItemsDTO.getQuantity());
            newCartItems.setAmount(product.getPrice().multiply(new BigDecimal(newCartItems.getQuantity())));
            CartItem resCartItems = cartItemsService.save(newCartItems);
            Cart cart = cartService.findByUserId(user.getId()).get();
            cart.setTotalAmount(getTotalAmount());
            cartService.save(cart);
            return new ResponseEntity<>(resCartItems.toCartDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Edit is fail,please reddit later !", HttpStatus.BAD_REQUEST);
    }

    //deleted cart
    @GetMapping("/deleted/{id}")
    public ResponseEntity<?> deletedCartItems(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemsService.findById(id);
        cartItemsService.remove(id);
        User user = userService.findByUsername(getUserNamePrincipal()).get();
        Cart cart = cartService.findByUserId(user.getId()).get();
        cart.setTotalAmount(getTotalAmount());
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //checked
    @PostMapping("/checked/{id}")
    public ResponseEntity<?> checkedEntity(@PathVariable Long id, @RequestBody ListCartItemsDTO cartItemsDTO) {
        CartItem cartItem = cartItemsService.findById(id).get();
        cartItem.setChecked(cartItemsDTO.isChecked());
        CartItem newCartItem = cartItemsService.save(cartItem);
        User user = userService.findByUsername(getUserNamePrincipal()).get();
        Cart cart = cartService.findByUserId(user.getId()).get();
        cart.setTotalAmount(getTotalAmount());
        cartService.save(cart);
        return new ResponseEntity<>(newCartItem.toCartDTO(), HttpStatus.OK);
    }

    //add to cart
    @PostMapping
    public ResponseEntity<?> addNewCartItems(@Validated @RequestBody ListCartItemsDTO cartItemsDTO, BindingResult result) {
        if (result.hasFieldErrors()) {
            return new ResponseEntity<>("Request has field error, please check input again !", HttpStatus.BAD_REQUEST);
        }
        if (getUserNamePrincipal().isEmpty()) {
            return new ResponseEntity<>("/login", HttpStatus.BAD_REQUEST);
        }
        String userName = getUserNamePrincipal();
        User user = userService.findByUsername(userName).get();
        Cart cart;
        if (cartService.existsCartByUserId(user.getId())) {
            cart = cartService.findByUserId(user.getId()).get();
        } else {
            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setTotalAmount(new BigDecimal(0));
            newCart.setId(0L);
            cart = cartService.save(newCart);
        }
        Optional<CartItem> newCartItem = cartItemsService.findByProductIdAndUserId(cartItemsDTO.getProductId(), user.getId());
        CartItem cartItem;
        if (!newCartItem.isPresent()) {
            cartItem = cartItemsDTO.toCartItem();
        } else {
            cartItem = newCartItem.get();
            int oldQuantity = cartItem.getQuantity();
            cartItem.setQuantity(oldQuantity + cartItemsDTO.getQuantity());
        }
        BigDecimal newAmount = cartItem.getAmount().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
        cartItem.setAmount(newAmount);
        cartItem.setUserId(user.getId());
        cartItem.setCart(cart);
        CartItem newCartItems = cartItemsService.save(cartItem);
        cart.setTotalAmount(getTotalAmount());
        cartService.save(cart);
        return new ResponseEntity<>(newCartItems.toCartDTO(), HttpStatus.OK);
    }


    //get user logging
    public String getUserNamePrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        return username;
    }

    //get total
    public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal(0);
        User user = userService.findByUsername(getUserNamePrincipal()).get();
        List<CartItem> cartItems = (List<CartItem>) cartItemsService.findByCheckedIsTrue(user.getId());
        for (CartItem cartItem : cartItems) {
            BigDecimal amount = new BigDecimal(String.valueOf(cartItem.getAmount()));
            total = total.add(amount);
        }
        return total;
    }
}
