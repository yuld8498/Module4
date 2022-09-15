package com.codegym.mavenbankingajax.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transfer extends BasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id", nullable = false)
    private Customer recipient;

    @Column(name = "transfer_amount", nullable = false)
    private BigDecimal transferAmount;

    @Column(name = "total", nullable = false)
    private BigDecimal totalTransfer;

    @Column(name = "fees_amount")
    private BigDecimal feesAmount;

    private int fees;
}
