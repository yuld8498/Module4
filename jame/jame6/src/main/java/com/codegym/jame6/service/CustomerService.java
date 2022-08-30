package com.codegym.jame6.service;

import com.codegym.jame6.model.Customer;
import com.codegym.jame6.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List findAll() {
        return  customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
