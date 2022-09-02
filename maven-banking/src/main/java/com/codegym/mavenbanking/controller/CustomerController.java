package com.codegym.mavenbanking.controller;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Deposit;
import com.codegym.mavenbanking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showListCustomer(){
        ModelAndView modelAndView = new ModelAndView("customer/index");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/deposit/{id}")
    public ModelAndView showFormDeposit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/deposit");
        modelAndView.addObject("customer", customerService.findById(id));
        Deposit deposit = new Deposit();
        deposit.setCustomerId(id);
        modelAndView.addObject("deposit", deposit);
        return modelAndView;
    }
    @GetMapping("/transfer/{id}")
    public ModelAndView showFormTransfer(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/transfer");
        Optional<Customer> customer = customerService.findById(id);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }
    @GetMapping("/withdraw/{id}")
    public ModelAndView showFormWithdraw(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/withdraw");
        Optional<Customer> customer = customerService.findById(id);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }
    @GetMapping("/suspended/{id}")
    public ModelAndView showFormSuspension(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/suspension");
        Optional<Customer> customer = customerService.findById(id);
//        modelAndView.addObject("suspended",null);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }
    @PostMapping("/suspended/{id}")
    public ModelAndView Suspended(@PathVariable Long id,@ModelAttribute("customer") Customer customer) {
        customerService.remove(id);
        ModelAndView modelAndView = new ModelAndView("/customer/suspension");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("suspended","complete");
        modelAndView.addObject("message", "Customer suspended successfully");
        return modelAndView;
    }
}
