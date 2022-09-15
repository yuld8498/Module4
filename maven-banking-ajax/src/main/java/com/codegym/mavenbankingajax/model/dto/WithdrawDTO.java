package com.codegym.mavenbankingajax.model.dto;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Withdraw;
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
public class WithdrawDTO {
    private Long customerId;
    private String fullName;
    private BigDecimal balance;
    private BigDecimal transactionAmount;

    @Override
    public String toString() {
        return "WithdrawDTO{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", transactionAmount=" + transactionAmount +
                '}';
    }

    public Withdraw toWithdraw(Customer customer){
        return new Withdraw()
                .setCustomer(customer)
                .setTransactionAmount(transactionAmount)
                ;
    }
}
