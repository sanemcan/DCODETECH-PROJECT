package com.dcodetech.ATMMACHINE.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import com.dcodetech.ATMMACHINE.dao.Pindao;
import com.dcodetech.ATMMACHINE.pojo.PinChange;

@RestController
public class PinchangeController {

    @Autowired
    private Pindao pindao;

    // @PostMapping("/pinChange")
    // public ResponseEntity<Map<String, Object>> pinChange(@RequestBody PinChange
    // pinchange) {
    // boolean success = pindao.savePinDetails(pinchange);
    // Map<String, Object> response = new HashMap<>();

    // if (success) {
    // response.put("success", true);
    // response.put("message", " Pin Change successfully!");
    // } else {
    // response.put("success", false);
    // response.put("message", "Failed to change pin . Please try again.");
    // }
    // return new ResponseEntity<>(response, HttpStatus.OK);
    // }

    @PostMapping("/pinchange")
    public ResponseEntity<String> pinChange(@RequestBody PinChange pinChange, HttpServletRequest request) throws SQLException {
        int accountid = Integer.parseInt(request.getParameter("account_id"));

        if (pindao.ifaccountExist(accountid)) {

            boolean success = pindao.savePinDetails(pinChange);
            return ResponseEntity.ok("Pin Updated Succesfully");

        }

        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found ");
        }

    }

}
