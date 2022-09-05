package com.codegym.mavenbanking.service.transfer;

import com.codegym.mavenbanking.model.Transfer;
import com.codegym.mavenbanking.service.IGeneralService;

import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {
    void deletedTransfer(Long senderId, Long recipientId);
    List<Transfer> findAllNotDeleted();
    void updateDeleted(Long customerId);
}
