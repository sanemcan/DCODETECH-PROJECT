package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.PinChange;

@Component
public class Pindao {

    public boolean savePinDetails(PinChange pinchange) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DBUtils.openConnection();
            String query = "UPDATE  account_details SET pin = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pinchange.getNewpin());
            preparedStatement.setString(2, pinchange.getAccountnumber());

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

    public boolean ifAccountAndPinMatch(int accid, String currentPin) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DBUtils.openConnection();
            String query = "Select * from account_details where id=? and pin=?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, accid);
            preparedStatement.setString(2, currentPin);

            ResultSet rs = preparedStatement.executeQuery();
            boolean accountAndPinMatch = rs.next();
            rs.close();
            DBUtils.closeConnection();

            return accountAndPinMatch;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}