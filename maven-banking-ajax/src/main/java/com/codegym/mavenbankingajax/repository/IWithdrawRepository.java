package com.codegym.mavenbankingajax.repository;

import com.codegym.mavenbankingajax.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWithdrawRepository extends JpaRepository<Withdraw, Long> {
}
