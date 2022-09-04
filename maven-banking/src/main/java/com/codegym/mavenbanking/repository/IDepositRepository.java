package com.codegym.mavenbanking.repository;
import com.codegym.mavenbanking.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Long> {
}
