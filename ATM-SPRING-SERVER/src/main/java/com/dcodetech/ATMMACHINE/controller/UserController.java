package com.dcodetech.ATMMACHINE.controller;

import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;

import java.util.HashMap;   //key value pair store krnya sathi for eg: JSON
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController     // create krnya sathi RESTful web service requests
public class UserController {

    @Autowired     //type of a dependency injection...he use kela bcz userdao madhle methods use kru shakto aata aapn
    private Userdao userdao;

    @PostMapping("/api/createAccount")      //data save karaych ahe mhnun post mapping use kela

    //creataccount method banvla
    //responseentity return type ahe method chi ji http response represent krte
    //@requestbody client side ne data receive krnya sathi ast
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountCreation accountCreation) {        
        boolean success = userdao.saveAccountDetails(accountCreation); //details pass kele ithe 
        Map<String, Object> response = new HashMap<>(); //response banvla ahe ani tyat jo response yeto to store kela   
        if (success) {
            response.put("success", true);
            response.put("message", "Account created successfully!");
            response.put("Username","SAGAR");
        } else {
            response.put("success", false);
            response.put("message", "Failed to create account. Please try again.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


