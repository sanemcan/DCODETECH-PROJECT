package com.dcodetech.ATMMACHINE.pojo;

public class ChequebookReq {


    private String firstname;
    private String middlename;
    private String lastname;
    private String phoneno;
    private String emailid;
    private String date;
    private String accounttype;
    private String bankname;
    private int accountnumber;
    private String pin;
    private String startingcheque;
    private String endingcheque;
    private String leaves;

    public ChequebookReq(){

    }

    public ChequebookReq(String firstname, String middlename, String lastname, String phoneno, String emailid,
            String date, String accounttype, String bankname, int accountnumber, String pin, String startingcheque,
            String endingcheque, String leaves) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.phoneno = phoneno;
        this.emailid = emailid;
        this.date = date;
        this.accounttype = accounttype;
        this.bankname = bankname;
        this.accountnumber = accountnumber;
        this.pin = pin;
        this.startingcheque = startingcheque;
        this.endingcheque = endingcheque;
        this.leaves = leaves;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getStartingcheque() {
        return startingcheque;
    }

    public void setStartingcheque(String startingcheque) {
        this.startingcheque = startingcheque;
    }

    public String getEndingcheque() {
        return endingcheque;
    }

    public void setEndingcheque(String endingcheque) {
        this.endingcheque = endingcheque;
    }

    public String getLeaves() {
        return leaves;
    }

    public void setLeaves(String leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "ChequebookReq [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
                + ", phoneno=" + phoneno + ", emailid=" + emailid + ", date=" + date + ", accounttype=" + accounttype
                + ", bankname=" + bankname + ", accountnumber=" + accountnumber + ", pin=" + pin + ", startingcheque="
                + startingcheque + ", endingcheque=" + endingcheque + ", leaves=" + leaves + "]";
    }

}
