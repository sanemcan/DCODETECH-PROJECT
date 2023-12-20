package com.dcodetech.ATMMACHINE.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.MoneyTransferDetails;

import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MoneyTransferController {

    @Autowired           //dependency injection mahnun use karto moneytransferdetails dao cha methods use karyla
    private MoneyTransferDetails moneyTransferDetails;


    @PostMapping("/money-transfer")
        public ResponseEntity<Map<String,Object>>showresponseoftransfer(@RequestBody MoneyTransfer moneyTransfer){

          boolean success=moneyTransferDetails.saveMoneyTransferDetails(moneyTransfer);//line 18 cha userdao use kela
          Map<String,Object>response =new HashMap<>();//store kela data key value madhe
          if (success) {
              response.put("success", "true");
              response.put("message","money transfer successfully");
          }else{
        
            response.put("success", "false");
              response.put("message","money not transfer successfully so failed");
          }
        return new ResponseEntity<>(response,HttpStatus.OK); // rwesponse deto 2 meassage takto te yetil if kiva else hoil te
    }
        
      
    
    
    
}
