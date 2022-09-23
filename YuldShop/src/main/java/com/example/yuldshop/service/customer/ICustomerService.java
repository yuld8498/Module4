package com.example.yuldshop.service.customer;

import com.example.yuldshop.model.Customer;
import com.example.yuldshop.model.DTO.CustomerDTO;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.IGenericService;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGenericService<Customer> {
    boolean existsEmail(String email);
    boolean existsPhoneNumber(String phone);

    Customer findByUser(User user);
}
