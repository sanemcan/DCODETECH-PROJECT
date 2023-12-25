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

             // Get the current balances of the sender and recipient accounts
             double senderBalance = accountService.getBalance(moneyTransfer.getAccountnumber());
             double recipientBalance = accountService.getBalance(moneyTransfer.getRecipientaccountnumber());
 
             // Check if the sender has enough balance for the transfer
             double transactionAmount = Double.parseDouble(moneyTransfer.getTransactionammount());
             if (senderBalance < transactionAmount) {
                 System.out.println("Insufficient funds in the sender's account.");
                 return false;
             }
 
             // Update the balances
             double newSenderBalance = senderBalance - transactionAmount;
             double newRecipientBalance = recipientBalance + transactionAmount;
 
             // Update sender's balance in the database
             accountService.updateBalance(moneyTransfer.getAccountnumber(), newSenderBalance);
 
             // Update recipient's balance in the database
             accountService.updateBalance(moneyTransfer.getRecipientaccountnumber(), newRecipientBalance);

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
                DBUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
