package com.codegym.mavenbanking.repository;

import com.codegym.mavenbanking.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {

}
