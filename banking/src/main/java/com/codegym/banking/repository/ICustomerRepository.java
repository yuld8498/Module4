package com.codegym.banking.repository;


import com.codegym.banking.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends IGeneralRepository<Customer> {

}