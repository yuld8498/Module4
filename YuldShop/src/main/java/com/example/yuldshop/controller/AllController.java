package com.example.yuldshop.controller;

import com.example.yuldshop.model.Customer;
import com.example.yuldshop.model.DTO.CustomerDTO;
import com.example.yuldshop.model.DTO.UserDTO;
import com.example.yuldshop.model.Product;
import com.example.yuldshop.model.Role;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.Role.IRoleService;
import com.example.yuldshop.service.customer.ICustomerService;
import com.example.yuldshop.service.jwt.JwtService;
import com.example.yuldshop.service.product.IProductService;
import com.example.yuldshop.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AllController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICustomerService customerService;

    private String getPrincipal() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = "";
        }
        return username;
    }

    //get role

    private UserDTO getUserDTO(String userName) {
        User user = userService.findByUsername(userName).get();
        Role role = user.getRole();
        UserDTO userDTO = user.toUserDTO();
        userDTO.setRole(role.toRoleDTO());
        return userDTO;
    }

    @GetMapping
    public ModelAndView showProduct() {
        ModelAndView modelAndView = new ModelAndView();
        if (!getPrincipal().equals("")) {
            UserDTO userDTO = getUserDTO(getPrincipal());
            modelAndView.addObject("user", userDTO);
            modelAndView.addObject("role", userDTO.getRole());
            if (userDTO.getRole().getCode().equalsIgnoreCase("admin")) {
                modelAndView.setViewName("/product/listProductsAdmin");
                return modelAndView;
            }
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }

    //products
    @GetMapping("/products")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView();
        if (!getPrincipal().equals("")) {
            UserDTO userDTO = getUserDTO(getPrincipal());
            modelAndView.addObject("user", userDTO);
            modelAndView.addObject("role", userDTO.getRole());
            if (userDTO.getRole().getCode().equalsIgnoreCase("admin")) {
                modelAndView.setViewName("/product/listProductsAdmin");
                return modelAndView;
            }
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }

    @GetMapping("/products/admin")
    public ModelAndView showListProductAdmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/listProductsAdmin");
        if (!getPrincipal().equals("")) {
            modelAndView.addObject("user", getUserDTO(getPrincipal()));
            modelAndView.addObject("role", getUserDTO(getPrincipal()).getRole());
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        return modelAndView;
    }

    @GetMapping("/products/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/create");
        return modelAndView;
    }

    //customer
    @GetMapping("/customers")
    public ModelAndView beginToPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/login");
        if (!getPrincipal().equals("")) {
            modelAndView.addObject("user", getUserDTO(getPrincipal()));
            modelAndView.addObject("role", getUserDTO(getPrincipal()).getRole());
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        return modelAndView;
    }

    @GetMapping("/customers/password")
    public ModelAndView forgotPW() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/forgotpassword");
        return modelAndView;
    }

    //login
    @GetMapping("/login")
    public ModelAndView showformLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/login");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/list");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JWT")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                return modelAndView;
            }
        }
        return modelAndView;
    }

    //users

    @GetMapping("/users/register")
    public ModelAndView beginToPageRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");
        return modelAndView;
    }

    @GetMapping("/users/update")
    public ModelAndView createNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/updateUser");
        if (!getPrincipal().equals("")) {
            User user = userService.findByUsername(getPrincipal()).get();
            modelAndView.addObject("user", getUserDTO(getPrincipal()));
            modelAndView.addObject("role", getUserDTO(getPrincipal()).getRole());
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView showListOder() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/order/list");
        if (!getPrincipal().equals("")) {
            modelAndView.addObject("user", getUserDTO(getPrincipal()));
            modelAndView.addObject("role", getUserDTO(getPrincipal()).getRole());
        } else {
            modelAndView.addObject("user", null);
            modelAndView.addObject("role", null);
        }
        return modelAndView;
    }
}
