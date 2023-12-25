package com.dcodetech.ATMMACHINE.pojo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcodetech.ATMMACHINE.dao.Changephndao;
import com.dcodetech.ATMMACHINE.dao.Pindao;


@Service
public class ChangePhnService {

      private final Changephndao  changephndao;

    @Autowired
    public ChangePhnService(Changephndao changephndao) {
        this.changephndao = changephndao;
    }

    public boolean checkAccountAndPin(String accountnumber, String currentPin) throws SQLException {
        // Convert kela accountnumber to int
        int accountId = Integer.parseInt(accountnumber);

        // Call the method
        return changephndao.ifAccountAndPinMatch(accountId, currentPin);
    }

    public boolean updatePhoneNumber(Changephn changephn) {
        return changephndao.savePhnNumberUpadteDetails(changephn);
    }
    
}
