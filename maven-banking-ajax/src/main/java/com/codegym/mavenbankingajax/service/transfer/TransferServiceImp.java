package com.codegym.mavenbankingajax.service.transfer;

import com.codegym.mavenbankingajax.model.Transfer;
import com.codegym.mavenbankingajax.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TransferServiceImp implements ITransferService {
    @Autowired
    private ITransferRepository transferRepository;
    @Override
    public Iterable<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return transferRepository.findById(id);
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public void remove(Long id) {

    }
}
