package com.codegym.mavenbankingajax.model;

import com.codegym.mavenbankingajax.model.dto.WithdrawDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "withdraws")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class Withdraw extends BasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private BigDecimal transactionAmount;
}
