package com.dcodetech.ATMMACHINE.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;
 
@Component
public class Chequereqdao {
@Autowired
    Pindao pindao;
    public boolean ChequebookReqDeatils(ChequebookReq chequebookReq) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            // if (pindao.ifAccountAndPinMatch(chequebookReq.getAccountnumber(),chequebookReq.getPin())) {
            //        System.out.println("pin does not match ");
            //        return false;
            // }

            String query = "  INSERT INTO chequebook_req (first_name,middle_name,last_name,phone_no,email,date_of_req,account_type,bank_name,account_number,pin,starting_chequq_no,ending_chequq_no,leaves,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, chequebookReq.getFirstname());
                preparedStatement.setString(2, chequebookReq.getMiddlename());
                preparedStatement.setString(3, chequebookReq.getLastname());
                preparedStatement.setString(4, chequebookReq.getPhoneno());
                preparedStatement.setString(5, chequebookReq.getEmailid());
                preparedStatement.setString(6, chequebookReq.getDate());
                preparedStatement.setString(7, chequebookReq.getAccounttype());
                preparedStatement.setString(8, chequebookReq.getBankname());
                preparedStatement.setInt(9, chequebookReq.getAccountnumber());
                preparedStatement.setString(10, chequebookReq.getPin());
                preparedStatement.setString(11, chequebookReq.getStartingcheque());
                preparedStatement.setString(12, chequebookReq.getEndingcheque());
                preparedStatement.setString(13, chequebookReq.getLeaves());
                preparedStatement.setString(14, "pending");
           
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
       
    // public boolean ifPinMatch(String pin) throws SQLException {
    //     Connection connection = null;
    //     PreparedStatement preparedStatement = null;

    //     try {

    //         connection = DBUtils.openConnection();
    //         String query = "Select * from account_details where  pin=?";
    //         preparedStatement = connection.prepareStatement(query);

    //         preparedStatement.setString(1, pin);

    //         ResultSet rs = preparedStatement.executeQuery();
    //         boolean PinMatch = rs.next();
    //         rs.close();
    //         DBUtils.closeConnection();

    //         return PinMatch;

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    // }
}
