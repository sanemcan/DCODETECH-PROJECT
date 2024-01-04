package com.dcodetech.ATMMACHINE.pojo;

public class Changephn {
    
    private String accountnumber;
    private String previousphoneNo;
    private String phoneNo;
    private String pin;
    public Changephn() {
    }
    public Changephn(String accountnumber, String previousphoneNo, String phoneNo, String pin) {
        this.accountnumber = accountnumber;
        this.previousphoneNo = previousphoneNo;
        this.phoneNo = phoneNo;
        this.pin = pin;
    }
    public String getAccountnumber() {
        return accountnumber;
    }
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }
    public String getPreviousphoneNo() {
        return previousphoneNo;
    }
    public void setPreviousphoneNo(String previousphoneNo) {
        this.previousphoneNo = previousphoneNo;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
        
}