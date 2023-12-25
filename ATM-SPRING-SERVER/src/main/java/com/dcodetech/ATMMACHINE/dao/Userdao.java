package com.dcodetech.ATMMACHINE.dao;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class Userdao {

    // METHOD FOR SAVING ACCOUNT DETAILS
    public boolean saveAccountDetails(AccountCreation accountCreation) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            String query = "INSERT INTO account_details (account_type, bank_name, first_name, middle_name, last_name, date_of_birth, age, phone_no, email, aadhar_card_no, pin, passport_photograph,status,balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, accountCreation.getAccountType());
            preparedStatement.setString(2, accountCreation.getBankName());
            preparedStatement.setString(3, accountCreation.getFirstName());
            preparedStatement.setString(4, accountCreation.getMiddleName());
            preparedStatement.setString(5, accountCreation.getLastName());
            preparedStatement.setDate(6, java.sql.Date.valueOf(accountCreation.getDateOfBirth()));
            preparedStatement.setInt(7, accountCreation.getAge());
            preparedStatement.setString(8, accountCreation.getPhoneNo());
            preparedStatement.setString(9, accountCreation.getEmail());
            preparedStatement.setString(10, accountCreation.getAadharCardNo());
            preparedStatement.setString(11, accountCreation.getPin());
            preparedStatement.setString(12, accountCreation.getPassportPhotograph());
            preparedStatement.setString(13, "pending");
             preparedStatement.setString(14, "0");
            // starting la request send hoel tevha status pending set kela ahe ani jevha
            // admin request approve krel tr status approved hoel

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

    // METHOD FOR GETTING TRANSACTION DETAILS
    public boolean doesAccountIdExist(int accid, String accpin) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            String query = "SELECT * FROM user_details WHERE id_from = ? AND account_pin=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, accid);
            preparedStatement.setString(2, accpin);
            int rowsGot = preparedStatement.executeUpdate();
            return rowsGot > 0;
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
