package com.codegym.mavenbanking.service.customer;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Deposit;
import com.codegym.mavenbanking.service.IGeneralService;

import java.math.BigDecimal;

public interface ICustomerService extends IGeneralService<Customer> {
    Deposit doDeposit(Long customerId, BigDecimal transactionAmount, Deposit deposit);
    Boolean existsByEmail(String email);
}
