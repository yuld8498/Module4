package com.codegym.mavenbankingajax.service.customer;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.dto.DepositDTO;
import com.codegym.mavenbankingajax.model.dto.WithdrawDTO;
import com.codegym.mavenbankingajax.service.IGenaralService;

import java.math.BigDecimal;

public interface ICustomerService extends IGenaralService<Customer> {
    DepositDTO doDeposit(DepositDTO depositDTO);
    WithdrawDTO doWithdraw(WithdrawDTO withdrawDTO);
}
