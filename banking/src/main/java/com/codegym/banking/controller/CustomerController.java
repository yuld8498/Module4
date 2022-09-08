package com.codegym.banking.controller;

import com.codegym.banking.model.Customer;
import com.codegym.banking.model.Deposit;
import com.codegym.banking.service.customer.ICustomerService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;

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
        ModelAndView modelAndView = new ModelAndView("/customer/create");
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
    @PostMapping("/deposit/{id}")
    public ModelAndView confirmDeposit(@PathVariable Long id,
                                       @Validated @ModelAttribute Deposit deposit, BindingResult result){
        System.out.println(deposit.getTransactionAmount());
        ModelAndView modelAndView = new ModelAndView("/customer/deposit");
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("deposit", deposit);
        if (result.hasFieldErrors()) {
            modelAndView.addObject("script", true);
            return modelAndView;
        }
        modelAndView.addObject("success", "Successful deposit transaction");
        return modelAndView;
    }
}
