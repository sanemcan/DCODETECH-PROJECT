package com.dcodetech.ATMMACHINE.pojo;

public class TxnHistory {
    private int accid;
    private int pin;

    public TxnHistory(int accid, int pin) {
        this.accid = accid;
        this.pin = pin;
    }

    public TxnHistory() {
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "TxnHistory [accid=" + accid + ", pin=" + pin + "]";
    }
}
