package com.codegym.mavenbanking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "transfers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private Long senderId;

    @NotEmpty
    private Long recipientId;

    private int fees;

    private BigDecimal feesAmount;

    @Digits(integer =  9, fraction = 0)
    @Column(updatable = false)
    private BigDecimal transferAmount;
    private BigDecimal transactionAmount;
}
