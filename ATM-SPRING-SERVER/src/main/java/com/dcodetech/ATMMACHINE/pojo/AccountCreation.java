package com.dcodetech.ATMMACHINE.pojo;

public class AccountCreation {
    // atmadhe sarv frontend che private variable banvle  with their datatype frontend cha navasarkha nko
    private String accountType;
    private String bankName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private String phoneNo;
    private String email;
    private String aadharCardNo;
    private String pin;
    private String passportPhotograph;
     



    
    
    public AccountCreation() {
    }

    public AccountCreation(String accountType, String bankName, String firstName, String middleName, String lastName,
            String dateOfBirth, int age, String phoneNo, String email, String aadharCardNo, String pin,
            String passportPhotograph) {
                this.accountType = accountType;
                this.bankName = bankName;
                this.firstName = firstName;
                this.middleName = middleName;
                this.lastName = lastName;
                this.dateOfBirth = dateOfBirth;
                this.age = age;
                this.phoneNo = phoneNo;
                this.email = email;
                this.aadharCardNo = aadharCardNo;
                this.pin = pin;
                this.passportPhotograph = passportPhotograph;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPassportPhotograph() {
        return passportPhotograph;
    }

    public void setPassportPhotograph(String passportPhotograph) {
        this.passportPhotograph = passportPhotograph;
    }

    @Override
    public String toString() {
        return "AccountCreation [accountType=" + accountType + ", bankName=" + bankName + ", firstName=" + firstName
                + ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", age="
                + age + ", phoneNo=" + phoneNo + ", email=" + email + ", aadharCardNo=" + aadharCardNo + ", pin=" + pin
                + ", passportPhotograph=" + passportPhotograph + "]";
    }
    
    
   
     

}
