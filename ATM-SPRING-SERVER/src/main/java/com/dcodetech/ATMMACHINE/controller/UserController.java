package com.dcodetech.ATMMACHINE.controller;

import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired //DEPENDENCY INJECTION
    private Userdao userdao;

    @PostMapping("/api/createAccount")
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountCreation accountCreation) {
        boolean success = userdao.saveAccountDetails(accountCreation);
        Map<String, Object> response = new HashMap<>();

        if (success) {
            response.put("success", true);
            response.put("message", "Account created successfully!");
        } else {
            response.put("success", false);
            response.put("message", "Failed to create account. Please try again.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
