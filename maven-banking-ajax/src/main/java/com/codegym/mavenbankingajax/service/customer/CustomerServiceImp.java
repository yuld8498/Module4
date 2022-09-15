package com.codegym.mavenbankingajax.service.customer;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.dto.DepositDTO;
import com.codegym.mavenbankingajax.model.dto.WithdrawDTO;
import com.codegym.mavenbankingajax.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImp implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public DepositDTO doDeposit(DepositDTO depositDTO) {
        customerRepository.incrementBalance(new BigDecimal(String.valueOf(depositDTO.getTransactionAmount())), depositDTO.getCustomerId());
        return depositDTO;
    }

    @Override
    public WithdrawDTO doWithdraw(WithdrawDTO withdrawDTO) {
        customerRepository.reduceBalance(withdrawDTO.getTransactionAmount(), withdrawDTO.getCustomerId());
        return withdrawDTO;
    }
}
