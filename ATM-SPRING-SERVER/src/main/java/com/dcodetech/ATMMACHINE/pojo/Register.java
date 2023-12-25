package com.dcodetech.ATMMACHINE.pojo;

public class Register {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;


    public Register() {
    }


    public Register(Long id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", username=" + username + ", password=" + password + "]";
    }

    
    
    
}
