package com.codegym.mavenbanking.repository;

import com.codegym.mavenbanking.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWithdrawRepository extends JpaRepository<Withdraw, Long> {
}
