package com.codegym.mavenbankingajax.repository;

import com.codegym.mavenbankingajax.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Long> {
}
