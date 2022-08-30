package com.example.jame62.repository;

import com.example.jame62.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}