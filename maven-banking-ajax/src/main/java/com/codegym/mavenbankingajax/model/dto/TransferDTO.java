package com.codegym.mavenbankingajax.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferDTO {
    private Long id;
    private Long senderId;
    private BigDecimal senderBalance;
    private String senderName;
    private Long recipientId;
    private BigDecimal recipientIdBalance;
    private String recipientIdName;
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
                ", recipientIdBalance=" + recipientIdBalance +
                ", recipientIdName='" + recipientIdName + '\'' +
                ", transferAmount=" + transferAmount +
                ", totalTransfer=" + totalTransfer +
                ", feesAmount=" + feesAmount +
                ", fees=" + fees +
                '}';
    }
}
