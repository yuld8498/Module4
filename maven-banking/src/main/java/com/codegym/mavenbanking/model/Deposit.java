package com.codegym.mavenbanking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Table(name = "deposits")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @NotNull(message = "The transaction amount is required")
    @DecimalMin(value = "49", message = "Transaction Amount must be greater than or equal to 50", inclusive = false)
    @DecimalMax(value = "10000001", message = "Transaction Amount must be less than or equal to 10.000.000", inclusive = false)
    private BigDecimal transactionAmount;
}
