package com.dcodetech.ATMMACHINE.pojo;

public class ChequebookReq {


    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String date;
    private String accountType;
    private String bankName;
    private String accountNumber;
    private String pin;
    private String startingChequeno;
    private String endingChequeno;
    private String leaves;

    public ChequebookReq(){

    }

    public ChequebookReq(String firstName, String middleName,String lastName, String phoneNo, String email,String date,
    String accountType,String bankName,String accountNumber, String pin, String startingChequeno,String  endingChequeno, String leaves )
    {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.phoneNo=phoneNo;
        this.email=email;
        this.date=date;
        this.accountType=accountType;
        this.bankName=bankName;
        this.accountNumber=accountNumber;
        this.pin=pin;
        this.startingChequeno=startingChequeno;
        this.endingChequeno=endingChequeno;
        this.leaves=leaves;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getStartingChequeno() {
        return startingChequeno;
    }

    public void setStartingChequeno(String startingChequeno) {
        this.startingChequeno = startingChequeno;
    }

    public String getEndingChequeno() {
        return endingChequeno;
    }

    public void setEndingChequeno(String endingChequeno) {
        this.endingChequeno = endingChequeno;
    }

    public String getLeaves() {
        return leaves;
    }

    public void setLeaves(String leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "ChequebookReq [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
                + ", phoneNo=" + phoneNo + ", email=" + email + ", date=" + date + ", accountType=" + accountType
                + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", pin=" + pin + ", startingChequeno="
                + startingChequeno + ", endingChequeno=" + endingChequeno + ", leaves=" + leaves + "]";
    }



    


}
