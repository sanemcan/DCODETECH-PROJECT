package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.AccountService;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;

@Component
public class MoneyTransferDetails {

    @Autowired
    private AccountService accountService;

    public boolean saveMoneyTransferDetails(MoneyTransfer moneyTransfer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();

            // Check if both account numbers exist in the database
            if (!accountService.doesAccountsExist(moneyTransfer.getAccountnumber(),
                    moneyTransfer.getRecipientaccountnumber())) {
                System.out.println("One or more account numbers do not exist.");
                return false;
            }

            // Check if the entered PIN is correct for the sender's account
            if (!accountService.isCorrectPin(moneyTransfer.getAccountnumber(), moneyTransfer.getPin())) {
                System.out.println("Incorrect PIN for the sender's account.");
                return false;
            }

            String query = "INSERT INTO money_transfer(account_number, Recipient_account_no, transaction_amount ,pin, phone_no, status) VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, moneyTransfer.getAccountnumber());
            preparedStatement.setString(2, moneyTransfer.getRecipientaccountnumber());
            preparedStatement.setString(3, moneyTransfer.getTransactionammount());
            preparedStatement.setString(4, moneyTransfer.getPin());
            preparedStatement.setString(5, moneyTransfer.getPhoneno());
            preparedStatement.setString(6, "successful"); // i want to set the status as "pending" initially

            System.out.println("MoneyTransfer details: " + moneyTransfer);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                DBUtils.closeconnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
