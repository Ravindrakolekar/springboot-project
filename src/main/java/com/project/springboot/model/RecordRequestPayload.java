package com.project.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "Record")
public class RecordRequestPayload {

    @Id
    @GeneratedValue()
    private Integer cardNumber;
    private String creditCardNumber;
    private Integer accountNumber;
    private Integer debitCardNumber;
    private String  cardHolderName;
    private String scerectKey;

    public String getScerectKey() {
        return scerectKey;
    }

    public void setScerectKey(String scerectKey) {
        this.scerectKey = scerectKey;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(Integer debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
