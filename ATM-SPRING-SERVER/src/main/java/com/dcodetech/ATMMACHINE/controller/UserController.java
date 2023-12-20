package com.dcodetech.ATMMACHINE.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;

@RestController     // create krnya sathi RESTful web service requests
                   //get chi request ,post chi requuest
public class UserController {
        @Autowired     //type of a dependency injection...he use kela bcz userdao madhle methods use kru shakto aata aapn
    private Userdao userdao;

    @PostMapping("/api/createAccount")      //data save karaych ahe mhnun post mapping use kela
    


    //method kartoy
    public ResponseEntity<Map<String,Object>>createAccount(@RequestBody AccountCreation accountCreation){

          boolean success=userdao.saveAccountDetails(accountCreation);//line 18 cha userdao use kela
          Map<String,Object>response =new HashMap<>();//store kela data key value madhe
          if (success) {
              response.put("success", "true");
              response.put("message","account created successfully");
          }else{
        
            response.put("success", "false");
              response.put("message","account  not created successfully so failed");
          }
        return new ResponseEntity<>(response,HttpStatus.OK); // rwesponse deto 2 meassage takto te yetil if kiva else hoil te
    }
}
