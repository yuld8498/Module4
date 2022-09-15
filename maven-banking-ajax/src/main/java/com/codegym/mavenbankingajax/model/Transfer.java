package com.codegym.mavenbankingajax.model;

import com.codegym.mavenbankingajax.model.dto.TransferDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
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

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", transferAmount=" + transferAmount +
                ", totalTransfer=" + totalTransfer +
                ", feesAmount=" + feesAmount +
                ", fees=" + fees +
                "} ";
    }

    public TransferDTO transferDTO(){
        return new TransferDTO()
                .setSenderId(sender.getId())
                .setSenderName(sender.getFullName())
                .setSenderBalance(sender.getBalance())
                .setRecipientId(recipient.getId())
                .setRecipientName(recipient.getFullName())
                .setRecipientBalance(recipient.getBalance())
                .setFees(fees)
                .setFeesAmount(feesAmount)
                .setTransferAmount(transferAmount)
                .setTotalTransfer(totalTransfer);
    }
}
