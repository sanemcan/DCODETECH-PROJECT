package com.dcodetech.ATMMACHINE.controller;

import com.dcodetech.ATMMACHINE.ChangePhnService;
import com.dcodetech.ATMMACHINE.JwtTokenProvider;
import com.dcodetech.ATMMACHINE.dao.Pindao;
import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;
import com.dcodetech.ATMMACHINE.pojo.Changephn;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;
import com.dcodetech.ATMMACHINE.pojo.PinChange;
import com.dcodetech.ATMMACHINE.pojo.PinService;
import com.dcodetech.ATMMACHINE.pojo.Register;
import com.dcodetech.ATMMACHINE.pojo.login;

import java.sql.SQLException;
import java.util.HashMap; //key value pair store krnya sathi for eg: JSON
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // create krnya sathi RESTful web service requests
public class UserController {

    // ! METHOD FOR SAVING ACCOUNT DETAILS
    @Autowired // type of a dependency injection...he use kela bcz userdao madhle methods use
               // kru shakto aata aapn
    private Userdao userdao;

    @PostMapping("/api/createAccount") // data save karaych ahe mhnun post mapping use kela

    // creataccount method banvla
    // responseentity return type ahe method chi ji http response represent krte
    // @requestbody client side ne data receive krnya sathi ast
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountCreation accountCreation) {
        boolean success = userdao.saveAccountDetails(accountCreation); // details pass kele ithe
        Map<String, Object> response = new HashMap<>(); // response banvla ahe ani tyat jo response yeto to store kela
        if (success) {
            response.put("success", true);
            response.put("message", "Account created successfully!");
            response.put("Username", "SAGAR");
        } else {
            response.put("success", false);
            response.put("message", "Failed to create account. Please try again.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ! METHOD FOR UPDATING PIN
    @Autowired
    private PinService pinService;

    @PutMapping("/pinupdate")
    public ResponseEntity<String> updatePin(@RequestBody PinChange pinChange) {
        try {
            boolean accountAndPinMatch = pinService.checkAccountAndPin(pinChange.getAccountnumber(),
                    pinChange.getCurrentpin());

            if (accountAndPinMatch) {
                boolean pinUpdateStatus = pinService.updatePin(pinChange);
                if (pinUpdateStatus) {
                    return ResponseEntity.ok("Pin updated successfully");
                } else {
                    return ResponseEntity.badRequest().body("Failed to update pin");
                }
            } else {
                return ResponseEntity.badRequest().body("Invalid account ID or current pin");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // ! METHOD FOR STORING REGISTER DATA
    @PostMapping("/atm/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Register register) {
        Map<String, Object> response = new HashMap<>();

        // Check if email or username already exists
        if (userdao.isEmailOrUsernameExists(register.getEmail(), register.getUsername())) {
            response.put("success", false);
            response.put("message", "Registration failed. Email or username already exists.");
            System.out.println("Server Response: " + response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Continue with the registration process
        boolean success = userdao.saveRegisterDetails(register);

        if (success) {
            response.put("success", true);
            response.put("message", "Registration successful! Confirmation email sent.");
            response.put("Username", register.getUsername());
            System.out.println("Server Response: " + response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("message", "Failed to register. Please try again.");
            System.out.println("Server Response: " + response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ! METHOD FOR DISPLAYING TXN HISTORY DATA
    @GetMapping("/history/{accountId}")
    public List<MoneyTransfer> getTxnHistoryByAccountId(@PathVariable int accountId) {
        try {
            return userdao.getTxnHistoryByAccountId(accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // !LOGIN & AUTHENTICATION
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody login loginRequest) throws SQLException {
        boolean isLoginSuccessful = userdao.usernamePassword(loginRequest.getUsername(), loginRequest.getPassword());
        Map<String, String> response = new HashMap<>();
        if (isLoginSuccessful) {
            Register user = userdao.getUserDetailsByUsername(loginRequest.getUsername());

            if (user != null) {
                String token = jwtTokenProvider.generateToken(user.getUsername());

                response.put("token", token);
                response.put("username", user.getUsername());
                response.put("firstname", user.getFirstname());
                response.put("lastname", user.getLastname());
                response.put("email", user.getEmail());
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "User details not found");
                return ResponseEntity.badRequest().body(response);
            }
        } else {
            response.put("message", "Incorrect password or username");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // ! CHEQUE BOOK REQUEST
    @Autowired
    private Pindao pindao;

    @PostMapping("/chequebookReq")
    public ResponseEntity<Map<String, Object>> requestChequebook(@RequestBody ChequebookReq chequebookReq)
            throws SQLException {

        Map<String, Object> response = new HashMap<>();
        if (!pindao.ifAccountAndPinMatch(chequebookReq.getAccountnumber(), chequebookReq.getPin())) {
            response.put("success", false);
            response.put("message", "Pin  does not match");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        boolean success = userdao.ChequebookReqDeatils(chequebookReq);
        if (success) {
            response.put("success", true);
            response.put("message", "Request Send Successfully");
        } else {
            response.put("success", false);
            response.put("message", "Request Failed to Send");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ! CHANGE PHONE NUMBER
    @Autowired
    private ChangePhnService changePhnService;

    @PutMapping("/NumberUpdate")
    public ResponseEntity<String> updatePhoneNumber(@RequestBody Changephn changephn) {
        try {
            boolean accountAndPhonebumberMatch = changePhnService.checkAccountAndPin(changephn.getAccountnumber(),
                    changephn.getPin());

            if (accountAndPhonebumberMatch) {
                boolean phoneUpdateStatus = changePhnService.updatePhoneNumber(changephn);
                if (phoneUpdateStatus) {
                    return ResponseEntity.ok("Phone Number updated successfully");
                } else {
                    return ResponseEntity.badRequest().body("Failed to update phone number");
                }
            } else {
                return ResponseEntity.badRequest().body("Invalid account ID or current pin");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

}
