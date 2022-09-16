package com.codegym.mavenbankingajax.controller.res;


import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Deposit;
import com.codegym.mavenbankingajax.model.Transfer;
import com.codegym.mavenbankingajax.model.Withdraw;
import com.codegym.mavenbankingajax.model.dto.CustomerDTO;
import com.codegym.mavenbankingajax.model.dto.DepositDTO;
import com.codegym.mavenbankingajax.model.dto.TransferDTO;
import com.codegym.mavenbankingajax.model.dto.WithdrawDTO;
import com.codegym.mavenbankingajax.repository.ICustomerRepository;
import com.codegym.mavenbankingajax.service.customer.ICustomerService;
import com.codegym.mavenbankingajax.service.deposit.IDepositService;
import com.codegym.mavenbankingajax.service.transfer.ITransferService;
import com.codegym.mavenbankingajax.service.withdraw.IWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class ResCustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IDepositService depositService;
    @Autowired
    private IWithdrawService withdrawService;
    @Autowired
    private ITransferService transferService;

    //get all customer to customerDTO
    @GetMapping()
    public ResponseEntity<List<?>> findAll() {
        List<Customer> customers = customerService.findAllByDeletedIsFalse();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(customer.toCustomerDTO());
        }
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    //get customer to customerDTO by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Customer customer = customerService.findById(id).get();
        CustomerDTO customerDTO = customer.toCustomerDTO();
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    //create customer from customerDTO
    @PostMapping("")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerService.existsEmail(customerDTO.getEmail())|| customerService.existsPhone(customerDTO.getPhone())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Customer customer = customerDTO.toCustomer();
            Customer newCustomer = customerService.save(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        }
    }

    //delete customer from customerDTO by id
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<?> deletedCustomer(@PathVariable Long id) {
        Customer customer = customerService.findById(id).get();
        customer.setDeleted(true);
        Customer newCustomer = customerService.save(customer);
        CustomerDTO customerDTO = newCustomer.toCustomerDTO();
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    //update customer from customerDTO by id
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.findById(id).get();
       if (customer.getEmail().equals(customerDTO.getEmail())||customer.getPhone().equals(customerDTO.getPhone())){
           if (customerDTO.getId().equals(id)) {
               customer = customerDTO.toCustomer();
               customerService.save(customer);
               return new ResponseEntity<>(customerDTO, HttpStatus.OK);
           }else {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
       }else {
           if (customerService.existsEmail(customerDTO.getEmail())|| customerService.existsPhone(customerDTO.getPhone())){
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }else {
               if (customerDTO.getId().equals(id)) {
                   customer = customerDTO.toCustomer();
                   customerService.save(customer);
                   return new ResponseEntity<>(customerDTO, HttpStatus.OK);
               }else {
                   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
               }
           }
       }
    }


    //withdraw form withdrawDTO
    @PostMapping("/withdraw")
    public ResponseEntity<?> doWithdrawFromWithdrawDTO(@RequestBody WithdrawDTO withdrawDTO) {
        Customer customer = customerService.findById(withdrawDTO.getCustomerId()).get();
        if (customer.getBalance().compareTo(withdrawDTO.getTransactionAmount()) >= 0) {
            Withdraw withdraw = withdrawDTO.toWithdraw(customer);
            withdrawService.save(withdraw);
            customerService.doWithdraw(withdrawDTO);
            customer = customerService.findById(withdrawDTO.getCustomerId()).get();
            return new ResponseEntity<>(customer.toCustomerDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
