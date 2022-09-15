package com.codegym.mavenbankingajax.model.dto;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class TransferDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderId;
    private BigDecimal senderBalance;
    private String senderName;
    private Long recipientId;
    private BigDecimal recipientBalance;
    private String recipientName;
    private BigDecimal transferAmount;
    private BigDecimal totalTransfer;
    private BigDecimal feesAmount;
    private int fees;

    @Override
    public String toString() {
        return "TransferDto{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", senderBalance=" + senderBalance +
                ", senderName='" + senderName + '\'' +
                ", recipientId=" + recipientId +
                ", recipientIdBalance=" + recipientBalance +
                ", recipientIdName='" + recipientName + '\'' +
                ", transferAmount=" + transferAmount +
                ", totalTransfer=" + totalTransfer +
                ", feesAmount=" + feesAmount +
                ", fees=" + fees +
                '}';
    }

    public Transfer toTransfer(Customer sender, Customer recipient){
        return new Transfer()
                .setRecipient(recipient)
                .setSender(sender)
                .setFees(fees)
                .setTransferAmount(transferAmount)
                .setFeesAmount(feesAmount)
                .setTotalTransfer(totalTransfer);
    }
}
