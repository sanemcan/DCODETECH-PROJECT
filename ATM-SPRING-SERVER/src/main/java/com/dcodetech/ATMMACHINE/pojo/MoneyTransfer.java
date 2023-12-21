package com.dcodetech.ATMMACHINE.pojo;

public class MoneyTransfer {
    private String accountnumber;
    private String recipientaccountnumber;
    private String transactionammount;
    private String phoneno;
    private String pin;

    public MoneyTransfer() {
    }

    public MoneyTransfer(String accountnumber, String recipientaccountnumber, String transactionammount, String phoneno,
            String pin) {
        this.accountnumber = accountnumber;
        this.recipientaccountnumber = recipientaccountnumber;
        this.transactionammount = transactionammount;
        this.phoneno = phoneno;
        this.pin = pin;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getRecipientaccountnumber() {
        return recipientaccountnumber;
    }

    public void setRecipientaccountnumber(String recipientaccountnumber) {
        this.recipientaccountnumber = recipientaccountnumber;
    }

    public String getTransactionammount() {
        return transactionammount;
    }

    public void setTransactionammount(String transactionammount) {
        this.transactionammount = transactionammount;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "MoneyTransfer [accountnumber=" + accountnumber + ", recipientaccountnumber=" + recipientaccountnumber
                + ", transactionammount=" + transactionammount + ", phoneno=" + phoneno + ", pin=" + pin + "]";
    }

}