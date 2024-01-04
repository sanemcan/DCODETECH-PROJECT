package com.dcodetech.ATMMACHINE.pojo;

import org.springframework.stereotype.Component;

@Component
public class Register {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    public Register() {
    }

    public Register(String firstname, String lastname, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailid(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register [firstname=" + firstname + ", lastname=" + lastname + ", emailid=" + email + ", username="
                + username + ", password=" + password + "]";
    }

}
