package com.dcodetech.ATMMACHINE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.dcodetech.ATMMACHINE.dao.ChequeStatusdao;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;

import java.util.List;
import org.springframework.ui.Model;


import org.springframework.stereotype.Controller;



public class ChequeStatusController {
    
    @Autowired
    ChequeStatusdao chequeStatusdao;

    @GetMapping("/chequeStatus")
    public String getChequeStatus(Model model) {
        List<ChequebookReq> chequebookRequests = chequeStatusdao.getAllChequebookRequests();
        model.addAttribute("chequebookRequests", chequebookRequests);
        return "chequebookreq-status"; // This should match the name of your HTML file
    }
}
