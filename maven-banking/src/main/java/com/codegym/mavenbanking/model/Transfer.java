package com.codegym.mavenbanking.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transfers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long senderId;

    private Date created_at;

    private int deleted;
    @NotNull
    private Long recipientId;

    private int fees;

    private BigDecimal feesAmount;

    @Column(updatable = false)
    private BigDecimal transferAmount;
    private BigDecimal transactionAmount;

    public Transfer(Long senderId, Long recipientId, int fees, BigDecimal feesAmount, BigDecimal transferAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transferAmount = transferAmount;
    }
}
