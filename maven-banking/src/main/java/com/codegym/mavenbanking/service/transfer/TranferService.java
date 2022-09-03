package com.codegym.mavenbanking.service.transfer;

import com.codegym.mavenbanking.model.Transfer;
import com.codegym.mavenbanking.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TranferService implements ITransferService{

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
        transferRepository.save(transfer);
        return transfer;
    }

    @Override
    public void remove(Long id) {
        transferRepository.deleteById(id);
    }
}
