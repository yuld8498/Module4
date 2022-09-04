package com.codegym.mavenbanking.controller;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Deposit;
import com.codegym.mavenbanking.model.Items.TransferItem;
import com.codegym.mavenbanking.model.Transfer;
import com.codegym.mavenbanking.repository.IDepositRepository;
import com.codegym.mavenbanking.service.customer.ICustomerService;
import com.codegym.mavenbanking.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITransferService transferService;

    @GetMapping("")
    public ModelAndView showListCustomer(){
        ModelAndView modelAndView = new ModelAndView("customer/index");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer");
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("script", true);
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else if (customerService.existsByEmail(customer.getEmail())){
            modelAndView.addObject("errors", "Email is already exists");
            modelAndView.addObject("customer",  customer);
            return modelAndView;
            }else {
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("success", "New customer created successfully");
            customerService.save(customer);
            return modelAndView;
        }
    }

    //Deposit
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
    public ModelAndView confirmDeposit(@Validated @ModelAttribute("deposit")Deposit deposit, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/customer/deposit");
        modelAndView.addObject("customer", customerService.findById(deposit.getCustomerId()).get());
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("script", true);
            return modelAndView;
        }else {
            modelAndView.addObject("success", "Successful deposit transaction");
            customerService.doDeposit(deposit.getCustomerId(), deposit.getTransaction_amount(), deposit);
            return modelAndView;
        }
    }

    @GetMapping("/withdraw/{id}")
    public ModelAndView showFormWithdraw(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/withdraw");
        Optional<Customer> customer = customerService.findById(id);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }

    //Suspended
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
        modelAndView.addObject("success", "Customer suspended successfully");
        return modelAndView;
    }
    //List Transfer
    @GetMapping("/transfer")
    public ModelAndView showListTransfer(){
        List<TransferItem> items = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("/customer/listTransfer");

        List<Transfer> transferList = (List<Transfer>) transferService.findAll();
        for (Transfer transfer : transferList){
            TransferItem transferItem = new TransferItem(transfer.getSenderId(),
                    transfer.getRecipientId(),transfer.getTransferAmount(),transfer.getFees(),transfer.getFeesAmount());
            transferItem.setSenderName(customerService.findById(transfer.getSenderId()).get().getFullName());
            transferItem.setRecipientName(customerService.findById(transfer.getRecipientId()).get().getFullName());
            items.add(transferItem);
        }
        modelAndView.addObject("items", items);

        return modelAndView;
    }
}
