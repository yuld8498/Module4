package com.example.yuldshop.service.customer;

import com.example.yuldshop.model.Customer;
import com.example.yuldshop.model.DTO.CustomerDTO;
import com.example.yuldshop.model.User;
import com.example.yuldshop.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findCustomerByDeletedIsFalse();
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
    public boolean existsEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public boolean existsPhoneNumber(String phone) {
        return customerRepository.existsByPhone(phone);
    }

    @Override
    public Customer findByUser(User user) {
        return customerRepository.findByUser(user);
    }
}
