package com.dcodetech.ATMMACHINE.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.MoneyTransferDetails;
import com.dcodetech.ATMMACHINE.pojo.AccountService;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MoneyTransferController {

  @Autowired // dependency injection mahnun use karto moneytransferdetails dao cha methods
             // use karyla
  private MoneyTransferDetails moneyTransferDetails;

  @Autowired
  private AccountService accountService;

  @PostMapping("/money-transfer")
  public ResponseEntity<Map<String, Object>> showResponseOfTransfer(@RequestBody MoneyTransfer moneyTransfer) {
    System.out.println("Received Request Payload: " + moneyTransfer.toString());
    Map<String, Object> response = new HashMap<>();

    // Check if both sender and recipient account IDs exist
    if (!accountService.doesAccountExist(moneyTransfer.getAccountnumber())) {
      response.put("success", "false");
      response.put("message", "Sender account ID does not exist.");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

    if (!accountService.doesAccountExist(moneyTransfer.getRecipientaccountnumber())) {
      response.put("success", "false");
      response.put("message", "Recipient account ID does not exist.");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Check if the entered PIN is correct for the sender's account
    if (!accountService.isCorrectPin(moneyTransfer.getAccountnumber(), moneyTransfer.getPin())) {
      response.put("success", "false");
      response.put("message", "Incorrect PIN for the sender's account.");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Attempt to save money transfer details
    boolean success = moneyTransferDetails.saveMoneyTransferDetails(moneyTransfer);
    if (success) {
      response.put("success", "true");
      response.put("message", "Money transfer successful.");
    } else {
      response.put("success", "false");
      response.put("message", "Money transfer failed.");
    }


    // Update the balances in the response after successful money transfer
    double senderBalance = accountService.getBalance(moneyTransfer.getAccountnumber());
    double recipientBalance = accountService.getBalance(moneyTransfer.getRecipientaccountnumber());

    response.put("senderBalance", senderBalance);
    response.put("recipientBalance", recipientBalance);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}