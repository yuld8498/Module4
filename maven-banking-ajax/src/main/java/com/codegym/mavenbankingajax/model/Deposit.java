package com.codegym.mavenbankingajax.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "deposits")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class Deposit extends BasicInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;
}
