package com.codegym.mavenbanking.controller;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Items.TransferItem;
import com.codegym.mavenbanking.model.Transfer;
import com.codegym.mavenbanking.repository.ICustomerRepository;
import com.codegym.mavenbanking.repository.ITransferRepository;
import com.codegym.mavenbanking.service.customer.ICustomerService;
import com.codegym.mavenbanking.service.transfer.ITransferService;
import com.codegym.mavenbanking.service.transfer.TranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private ITransferService transferService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{id}")
    public ModelAndView showFormTransfer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transfer");
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        TransferItem transferItem = new TransferItem();
        Customer customer = customerService.findById(id).get();
        transferItem.setSenderId(customer.getId());
        transferItem.setFees(10);
        transferItem.setSenderName(customer.getFullName());
        for (Customer customer1 :customerList){
            if (customer1.getId().equals(id)){
                customerList.remove(customer1);
                break;
            }
        }
        modelAndView.addObject("transferItem",transferItem);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
    @PostMapping("/{id}")
    public ModelAndView transfer(@PathVariable Long  id,
                                 @Validated @ModelAttribute("transferItem") TransferItem transferItem, BindingResult bindingResult){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ModelAndView modelAndView = new ModelAndView("/transfer/transfer");
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        Customer customer = customerService.findById(id).get();
        modelAndView.addObject("transferItem",transferItem);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerList", customerList);
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("script",true);
            return modelAndView;
        }else {
            Transfer transfer = new Transfer(transferItem.getSenderId(),transferItem.getRecipientId(),
                    transferItem.getFees(),transferItem.getFeesAmount(),transferItem.getTransferAmount());
            transfer.setTransactionAmount(transferItem.getTransactionAmount());
            transfer.setCreated_at(timestamp);
            transfer.setFeesAmount(transferItem.getTransactionAmount().subtract(transferItem.getTransferAmount()));
            if (customer.getBalance().compareTo(transferItem.getTransactionAmount())<0){
                modelAndView.addObject("errors","insufficient balance");
                return modelAndView;
            }
            transferService.save(transfer);
            customerService.doTransfer(transfer.getSenderId(), transfer.getRecipientId(), transfer.getTransactionAmount(),transfer.getTransferAmount());
            modelAndView.addObject("success","Transfer is successfully");
            return modelAndView;
        }
    }
}
