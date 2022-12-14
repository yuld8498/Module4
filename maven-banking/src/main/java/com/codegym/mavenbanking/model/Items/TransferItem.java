package com.codegym.mavenbanking.model.Items;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransferItem {

    @NotNull(message = "Sender ID is required")
    private Long senderId;
    private String senderName;
    @NotNull(message = "Recipient ID is required")
    private Long recipientId;
    private String recipientName;
    @NotNull(message = "Transfer Amount is required")
    private BigDecimal transferAmount;
    private int fees;
    private BigDecimal feesAmount;
    private BigDecimal transactionAmount;

    public TransferItem() {
    }

    public TransferItem(Long senderId, Long recipientId, BigDecimal transferAmount, int fees, BigDecimal feesAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
    }

    public TransferItem(Long senderId, String senderName, Long recipientId, String recipientName, BigDecimal transferAmount, int fees, BigDecimal feesAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
    }

    public TransferItem(Long senderId, String senderName, Long recipientId,
                        String recipientName, BigDecimal transferAmount, int fees, BigDecimal feesAmount, BigDecimal transactionAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public BigDecimal getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(BigDecimal feesAmount) {
        this.feesAmount = feesAmount;
    }

    @Override
    public String toString() {
        return "TransferItem{" +
                "senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", recipientId=" + recipientId +
                ", recipientName='" + recipientName + '\'' +
                ", transferAmount=" + transferAmount +
                ", fees=" + fees +
                ", feesAmount=" + feesAmount +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
