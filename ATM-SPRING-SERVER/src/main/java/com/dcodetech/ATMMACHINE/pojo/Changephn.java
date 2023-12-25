package com.dcodetech.ATMMACHINE.pojo;

public class Changephn {
    
    private String accountnumber;
    private String previousphonenummber;
    private String phonenumber;
    private String pin;
    public Changephn() {
    }
    public Changephn(String accountnumber, String previousphonenummber, String phonenumber, String pin) {
        this.accountnumber = accountnumber;
        this.previousphonenummber = previousphonenummber;
        this.phonenumber = phonenumber;
        this.pin = pin;
    }
    public String getAccountnumber() {
        return accountnumber;
    }
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }
    public String getPreviousphonenummber() {
        return previousphonenummber;
    }
    public void setPreviousphonenummber(String previousphonenummber) {
        this.previousphonenummber = previousphonenummber;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    @Override
    public String toString() {
        return "Changephn [accountnumber=" + accountnumber + ", previousphonenummber=" + previousphonenummber
                + ", phonenumber=" + phonenumber + ", pin=" + pin + "]";
    }

   

    


    
}