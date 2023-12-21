package com.dcodetech.ATMMACHINE.controller;


import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.Chequereqdao;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ChequereqController {

     @Autowired
    private Chequereqdao chequereqdao;

    @PostMapping("/api/chequebookReq")
    public ResponseEntity<Map<String, Object>> requestChequebook(@RequestBody ChequebookReq chequebookReq) {
          boolean success =chequereqdao.ChequebookReqDeatils(chequebookReq); 
          Map<String, Object> response =new HashMap<>();
          
          if (success) {
            response.put("success", true);
            response.put("message", "Request Send Successfully");
            

          } else {
            response.put("success", false);
            response.put("message", "Request  Failed Send ");
          }
         return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
