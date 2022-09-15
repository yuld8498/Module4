package com.codegym.mavenbankingajax.service.customer;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.dto.DepositDTO;
import com.codegym.mavenbankingajax.model.dto.TransferDTO;
import com.codegym.mavenbankingajax.model.dto.WithdrawDTO;
import com.codegym.mavenbankingajax.service.IGenaralService;

import java.math.BigDecimal;
import java.util.List;

public interface ICustomerService extends IGenaralService<Customer> {
    DepositDTO doDeposit(DepositDTO depositDTO);
    WithdrawDTO doWithdraw(WithdrawDTO withdrawDTO);
    TransferDTO doTransfer(TransferDTO transferDTO);
    List<Customer> findAllByDeletedIsFalse();
    Customer findByEmail(String email);
    boolean existsEmail(String email);
    boolean existsPhone(String phoneNumber);
}
