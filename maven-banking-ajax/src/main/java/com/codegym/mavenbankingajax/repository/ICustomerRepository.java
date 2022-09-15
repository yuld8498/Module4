package com.codegym.mavenbankingajax.repository;

import com.codegym.mavenbankingajax.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying(clearAutomatically=true, flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance + :transactionAmount WHERE c.id = :id")
    void incrementBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);
    @Modifying(clearAutomatically=true, flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id ")
    void reduceBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);

   List<Customer> searchAllByDeletedIsFalse();
   Customer findCustomerByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
