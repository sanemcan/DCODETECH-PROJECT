package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.Login;
import com.dcodetech.ATMMACHINE.pojo.Register;


@Component
public class Logindao {
    public boolean ifusernameAndPasswordMatch(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
           
           
            String query = "Select * from Register_table where username=? and Userpassword=?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            boolean usernameAndPasswordMatch = rs.next();
            rs.close();
            DBUtils.closeConnection();

            return usernameAndPasswordMatch;
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