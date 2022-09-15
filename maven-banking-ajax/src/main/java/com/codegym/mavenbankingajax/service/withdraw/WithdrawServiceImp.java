package com.codegym.mavenbankingajax.service.withdraw;

import com.codegym.mavenbankingajax.model.Withdraw;
import com.codegym.mavenbankingajax.repository.IWithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WithdrawServiceImp implements IWithdrawService{
    @Autowired
    private IWithdrawRepository withdrawRepository;
    @Override
    public Iterable<Withdraw> findAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public Optional<Withdraw> findById(Long id) {
        return withdrawRepository.findById(id);
    }

    @Override
    public Withdraw save(Withdraw withdraw) {
        return withdrawRepository.save(withdraw);
    }

    @Override
    public void remove(Long id) {

    }
}
