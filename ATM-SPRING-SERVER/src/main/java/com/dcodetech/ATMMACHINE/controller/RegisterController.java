package com.dcodetech.ATMMACHINE.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.ui.context.support.SpringTemplateEngine;

import com.dcodetech.ATMMACHINE.dao.Registerdao;
import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;
import com.dcodetech.ATMMACHINE.pojo.PinChange;
import com.dcodetech.ATMMACHINE.pojo.PinService;
import com.dcodetech.ATMMACHINE.pojo.Register;
import org.springframework.mail.javamail.JavaMailSender;


@RestController
public class RegisterController {

    // @Autowired
    // private JavaMailSender mailSender;

//    @Autowired
//     private SpringTemplateEngine templateEngine;


    @Autowired // type of a dependency injection...he use kela bcz userdao madhle methods use
               // kru shakto aata aapn
    private Registerdao registerdao;

     @PostMapping("/registerform")
     public ResponseEntity<Map<String, Object>> showResponseOfTransfer(@RequestBody Register register) throws SQLException {
    
     Map<String, Object> response = new HashMap<>();



// Check if both sender and recipient account IDs exist
    if (registerdao.findByUsernameOrByEmail(register.getUsername(),register.getEmail())) {
      response.put("success", "false");
      response.put("message", "account already exists with this username or email.");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

   

    // Attempt to save Regitrstion details details
    boolean success = registerdao.saveRegisterDetails(register);
    if (success) {
      response.put("success", "true");
      response.put("message", "Registration Successful");
    } else {
      response.put("success", "false");
      response.put("message", "Registration failed.");
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  
}
