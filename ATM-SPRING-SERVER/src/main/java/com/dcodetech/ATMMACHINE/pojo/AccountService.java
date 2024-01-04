package com.dcodetech.ATMMACHINE.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;

@Service
public class AccountService {

    public boolean doesAccountExist(String accountNumber) {
        try (
                Connection connection = DBUtils.openConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT COUNT(*) FROM account_details WHERE id = ?")) {
            preparedStatement.setString(1, accountNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String count = resultSet.getString(1);
                    return count != null && count.trim().equals(count != null ? count.trim() : null);
                    // return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCorrectPin(String accountNumber, String enteredPin) {
        try (Connection connection = DBUtils.openConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT pin FROM account_details WHERE id = ?")) {
            preparedStatement.setString(1, accountNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPin = resultSet.getString("pin");
                    System.out.println("Stored PIN: " + storedPin);
                    System.out.println("Entered PIN: " + enteredPin);
                    // Null check before trimming
                    return storedPin != null && storedPin.trim().equals(enteredPin != null ? enteredPin.trim() : null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean doesAccountsExist(String senderAccountNumber, String recipientAccountNumber) {
        return doesAccountExist(senderAccountNumber) && doesAccountExist(recipientAccountNumber);
    }

    public double getBalance(String accountNumber) {
        try (
                Connection connection = DBUtils.openConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT balance FROM account_details WHERE id = ?")) {
            preparedStatement.setString(1, accountNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Return a default value or handle the case appropriately
    }

    public void updateBalance(String accountNumber, double newBalance) {
        try (
                Connection connection = DBUtils.openConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("UPDATE account_details SET balance = ? WHERE id = ?")) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
