package com.codegym.mavenbanking.service.customer;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Deposit;
import com.codegym.mavenbanking.model.Withdraw;
import com.codegym.mavenbanking.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Deposit doDeposit(Long customerId, BigDecimal transactionAmount, Deposit deposit);
    void doTransfer(Long senderID, Long recipientID, BigDecimal transactionAmount, BigDecimal transferAmount);

    void doWithdraw(Withdraw withdraw);
    Boolean existsByEmail(String email);

    void doDeleted(Long id);

    List<Customer> selectAllCustomer();
}
