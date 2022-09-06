package com.codegym.mavenbanking.repository;

import com.codegym.mavenbanking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance + :balance WHERE c.id = :id ")
    void updateBalance(@Param("balance")BigDecimal balance,@Param("id") Long id);
    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance + :transferAmount WHERE c.id = :id ")
    void incrementBalance(@Param("transferAmount") BigDecimal transferAmount, @Param("id") Long id);
    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id ")
    void reduceBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);

    Boolean existsByEmail(String email);
    Customer findCustomerByFullName(String fullName);
     @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer t SET t.deleted = 1  WHERE t.id = :id")
    void setDeletedById(@Param("id") Long id);

     List<Customer> searchAllByDeletedIsFalse();
     boolean existsByPhone(@NotEmpty(message = "The phone number is required.") String phone);
}
