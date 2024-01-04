package com.dcodetech.ATMMACHINE;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcodetech.ATMMACHINE.dao.Userdao;
import com.dcodetech.ATMMACHINE.pojo.Changephn;

@Service
public class ChangePhnService {
    private final Userdao userdao;

    @Autowired
    public ChangePhnService(Userdao userdao) {
        this.userdao = userdao;
    }

    public boolean checkAccountAndPin(String accountnumber, String currentPin) throws SQLException {
        // Convert kela accountnumber to int
        int accountId = Integer.parseInt(accountnumber);

        // Call the method
        return userdao.ifAccountAndPinMatch(accountId, currentPin);
    }

    public boolean updatePhoneNumber(Changephn changephn) {
        return userdao.savePhnNumberUpadteDetails(changephn);
    }
}
