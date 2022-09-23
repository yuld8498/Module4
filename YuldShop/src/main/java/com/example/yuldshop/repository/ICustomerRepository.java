package com.example.yuldshop.repository;

import com.example.yuldshop.model.Customer;
import com.example.yuldshop.model.DTO.CustomerDTO;
import com.example.yuldshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Customer findByUser(User user);

    List<Customer>findCustomerByDeletedIsFalse();
}
