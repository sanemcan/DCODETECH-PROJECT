package com.dcodetech.ATMMACHINE.pojo;

import com.dcodetech.ATMMACHINE.dao.Pindao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PinService {

    private final Pindao pindao;

    @Autowired
    public PinService(Pindao pindao) {
        this.pindao = pindao;
    }

    public boolean checkAccountAndPin(String accountnumber, String currentPin) throws SQLException {
        // Convert kela accountnumber to int
        int accountId = Integer.parseInt(accountnumber);

        // Call the method
        return pindao.ifAccountAndPinMatch(accountId, currentPin);
    }

    public boolean updatePin(PinChange pinChange) {
        return pindao.savePinDetails(pinChange);
    }
}
