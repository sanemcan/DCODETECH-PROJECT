package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.dbutils;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;


@Component
public class MoneyTransferDetails {

     public boolean saveMoneyTransferDetails(MoneyTransfer moneyTransfer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dbutils.openConnection();
            String query = "INSERT INTO money_transfer(account_number, Recipient_account_no, transaction_amount ,pin, phone_no, status) VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, moneyTransfer.getAccountnumber());
            preparedStatement.setInt(2, moneyTransfer.getRecipientaccountnumber());
            preparedStatement.setInt(3, moneyTransfer.getTransactionamount());
            preparedStatement.setInt(4, moneyTransfer.getPIN());
            preparedStatement.setInt(5, moneyTransfer.getPhoneno());
            preparedStatement.setString(6, "successful"); // i want to set the status as "pending" initially

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                dbutils.closeconnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
}

  