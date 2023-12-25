package com.dcodetech.ATMMACHINE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.pojo.ChangePhnService;
import com.dcodetech.ATMMACHINE.pojo.Changephn;
import com.dcodetech.ATMMACHINE.pojo.PinChange;
import com.dcodetech.ATMMACHINE.pojo.PinService;


@RestController
public class ChangePhnNoController {

     @Autowired
    private ChangePhnService changePhnService;

    @PutMapping("/phone/NumberUpdate")
    public ResponseEntity<String> updatePhoneNumber(@RequestBody Changephn changephn) {
        try { 
            boolean accountAndPhonebumberMatch = changePhnService.checkAccountAndPin(changephn.getAccountnumber(), changephn.getPin());

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
