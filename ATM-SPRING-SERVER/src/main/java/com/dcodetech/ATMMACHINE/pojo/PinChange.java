package com.dcodetech.ATMMACHINE.pojo;

public class PinChange {
    private String accountnumber;
    private String cardnumber;
    private String expdate;
    private String currentpin;
    private String newpin;

    public PinChange() {

    }

    public PinChange(String accountnumber, String cardnumber, String expdate, String currentpin, String newpin) {

        this.accountnumber = accountnumber;
        this.cardnumber = cardnumber;
        this.expdate = expdate;
        this.currentpin = currentpin;
        this.newpin = newpin;
}

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getCurrentpin() {
        return currentpin;
    }

    public void setCurrentpin(String currentpin) {
        this.currentpin = currentpin;
    }

    public String getNewpin() {
        return newpin;
    }

    public void setNewpin(String newpin) {
        this.newpin = newpin;
    }

    @Override
    public String toString() {
        return "PinChange [accountnumber=" + accountnumber + ", cardnumber=" + cardnumber + ", expdate=" + expdate
                + ", currentpin=" + currentpin + ", newpin=" + newpin + "]";
    }

    
 


}
