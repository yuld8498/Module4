package com.example.jame62.Service;

import com.example.jame62.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
