package com.codegym.mavenbanking.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "deposits")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    private Date createdAt;

    @NotNull(message = "The transaction amount is required")
    @DecimalMin(value = "49", message = "Transaction Amount must be greater than or equal to 50", inclusive = false)
    @DecimalMax(value = "10000001", message = "Transaction Amount must be less than or equal to 10.000.000", inclusive = false)
    private BigDecimal transaction_amount;
}
