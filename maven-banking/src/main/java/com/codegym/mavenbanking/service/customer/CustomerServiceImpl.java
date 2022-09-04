package com.codegym.mavenbanking.service.customer;

import com.codegym.mavenbanking.model.Customer;
import com.codegym.mavenbanking.model.Deposit;
import com.codegym.mavenbanking.model.Withdraw;
import com.codegym.mavenbanking.repository.ICustomerRepository;
import com.codegym.mavenbanking.repository.IDepositRepository;
import com.codegym.mavenbanking.repository.IWithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IDepositRepository depositRepository;
    @Autowired
    private IWithdrawRepository withdrawRepository;

    @Override
    public Iterable findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Deposit doDeposit(Long customerId, BigDecimal transactionAmount, Deposit deposit) {
        customerRepository.incrementBalance(transactionAmount,customerId);
        System.out.println(deposit.toString());
        depositRepository.save(deposit);
        return deposit;
    }

    @Override
    public void doTransfer(Long senderID, Long recipientID, BigDecimal transactionAmount, BigDecimal transferAmount) {
        customerRepository.incrementBalance(transferAmount,recipientID);
        customerRepository.reduceBalance(transactionAmount,senderID);
    }

    @Override
    public void doWithdraw(Withdraw withdraw) {
        withdrawRepository.save(withdraw);
        customerRepository.reduceBalance(withdraw.getTransaction_amount(), withdraw.getCustomerId());
    }

    @Override
    public Boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
