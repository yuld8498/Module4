package com.codegym.mavenbankingajax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Customer sender;
    private Customer recipient;
    private BigDecimal transferAmount;
    private BigDecimal totalTransfer;
    private BigDecimal feesAmount;
    private int fees;
    private Date createAt;
}
