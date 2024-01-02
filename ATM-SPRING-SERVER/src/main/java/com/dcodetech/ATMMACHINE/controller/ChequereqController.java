package com.dcodetech.ATMMACHINE.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dcodetech.ATMMACHINE.dao.Chequereqdao;
import com.dcodetech.ATMMACHINE.dao.Pindao;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;
import com.dcodetech.ATMMACHINE.pojo.PinChange;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ChequereqController {

  @Autowired
  private Chequereqdao chequereqdao;
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
    boolean success = chequereqdao.ChequebookReqDeatils(chequebookReq);
    if (success) {
      response.put("success", true);
      response.put("message", "Request Send Successfully");
    } else {
      response.put("success", false);
      response.put("message", "Request Failed to Send");
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  
}
