package com.dcodetech.ATMMACHINE.pojo;

public class MoneyTransfer {
    private int accountnumber;
    private int recipientaccountnumber;
    private int transactionamount;
    // private String Date;
    private int PIN;
    private int phoneno;

    public MoneyTransfer() {
    }

    public MoneyTransfer(int accountnumber, int recipientaccountnumber, int transactionamount, int PIN, int phoneno) {
        this.accountnumber = accountnumber;
        this.recipientaccountnumber = recipientaccountnumber;
        this.transactionamount = transactionamount;
        this.PIN = PIN;
        this.phoneno = phoneno;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public int getRecipientaccountnumber() {
        return recipientaccountnumber;
    }

    public void setRecipientaccountnumber(int recipientaccountnumber) {
        this.recipientaccountnumber = recipientaccountnumber;
    }

    public int getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(int transactionamount) {
        this.transactionamount = transactionamount;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
       this. PIN = PIN;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "MoneyTransfer [accountnumber=" + accountnumber + ", recipientaccountnumber=" + recipientaccountnumber
                + ", transactionamount=" + transactionamount + ", PIN=" + PIN + ", phoneno=" + phoneno + "]";
    }


    

}

   