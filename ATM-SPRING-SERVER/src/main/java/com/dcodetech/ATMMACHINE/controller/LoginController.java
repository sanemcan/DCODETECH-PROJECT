package com.dcodetech.ATMMACHINE.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.Logindao;
import com.dcodetech.ATMMACHINE.dao.Registerdao;
import com.dcodetech.ATMMACHINE.pojo.Login;
import com.dcodetech.ATMMACHINE.pojo.Register;

@RestController
public class LoginController {

    @Autowired // type of a dependency injection...he use kela bcz userdao madhle methods use
               // kru shakto aata aapn
    private Logindao logindao;

     @GetMapping("/Loginform")
     public ResponseEntity<Map<String, Object>> showResponseOfTransfer(@RequestBody Login login) throws SQLException {
    
     Map<String, Object> response = new HashMap<>();

      
    // if (logindao.ifusernameAndPasswordMatch(login.getUsername(),login.getPassword())) {
    //   response.put("success", "false");
    //   response.put("message", "account already exists with this username or email.");
    //   return new ResponseEntity<>(response, HttpStatus.OK);
    // }

   

    // Attempt to save Regitrstion details details
    boolean success = logindao.ifusernameAndPasswordMatch(login.getUsername(), login.getPassword());
    if (success) {
      response.put("success", "true");
      response.put("message", "Login Successful");
    } else {
      response.put("success", "false");
      response.put("message", "Login  failed.");
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }



    
}

