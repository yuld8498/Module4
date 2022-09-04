package com.codegym.mavenbanking.controller;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Transfer;
import com.codegym.mavenbanking.repository.ITransferRepository;
import com.codegym.mavenbanking.service.customer.ICustomerService;
import com.codegym.mavenbanking.service.transfer.ITransferService;
import com.codegym.mavenbanking.service.transfer.TranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        Customer customer = customerService.findById(id).get();
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}
