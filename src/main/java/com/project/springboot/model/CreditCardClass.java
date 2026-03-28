package com.project.springboot.model;

public class CreditCardClass {

    private Integer accountNumber;
    private String accountHolderName;
    private Integer creditCardNumber;
    private Integer accountIFSCCode;

    public CreditCardClass(Integer accountNumber, String accountHolderName, Integer creditCardNumber, Integer accountIFSCCode) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.creditCardNumber = creditCardNumber;
        this.accountIFSCCode = accountIFSCCode;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getAccountIFSCCode() {
        return accountIFSCCode;
    }

    public void setAccountIFSCCode(Integer accountIFSCCode) {
        this.accountIFSCCode = accountIFSCCode;
    }
}
