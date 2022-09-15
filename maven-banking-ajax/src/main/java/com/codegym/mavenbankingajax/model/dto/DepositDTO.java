package com.codegym.mavenbankingajax.model.dto;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Deposit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DepositDTO {
    private Long customerId;
    private String fullName;
    private BigDecimal balance;
    private BigDecimal transactionAmount;

    @Override
    public String toString() {
        return "DepositDTO{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
    public Deposit toDeposit(Customer customer){
        return new Deposit()
                .setCustomer(customer)
                .setTransactionAmount(transactionAmount);
    }
}
