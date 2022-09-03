package com.codegym.mavenbanking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "withdraws")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private BigDecimal transactionAmount;
}
