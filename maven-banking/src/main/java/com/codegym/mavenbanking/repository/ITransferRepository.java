package com.codegym.mavenbanking.repository;

import com.codegym.mavenbanking.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {
}
