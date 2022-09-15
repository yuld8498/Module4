package com.codegym.mavenbankingajax.service.deposit;

import com.codegym.mavenbankingajax.model.Deposit;
import com.codegym.mavenbankingajax.repository.IDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DepositServiceImp implements IDepositService {
    @Autowired
    private IDepositRepository depositRepository;
    @Override
    public Iterable<Deposit> findAll() {
        return depositRepository.findAll();
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return depositRepository.findById(id);
    }

    @Override
    public Deposit save(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public void remove(Long id) {

    }
}
