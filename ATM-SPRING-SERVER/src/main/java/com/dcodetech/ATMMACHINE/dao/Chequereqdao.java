package com.dcodetech.ATMMACHINE.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import java.sql.Connection;


import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;



@Component
public class Chequereqdao {
    

    public boolean ChequebookReqDeatils(ChequebookReq   chequebookReq)
    {
          Connection connection = null;
           PreparedStatement preparedStatement =null;

           try {
            connection=DBUtils.openConnection();
            String query ="  INSERT INTO chequebook_req (first_name,middle_name,last_name,phone_no,email,date_of_req,account_type,bank_name,account_number,pin,starting_chequq_no,ending_chequq_no,leaves) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= connection.prepareStatement(query);

             preparedStatement.setString(1, chequebookReq.getFirstName());
             preparedStatement.setString(2, chequebookReq.getMiddleName());
             preparedStatement.setString(3, chequebookReq.getLastName());
             preparedStatement.setString(4, chequebookReq.getPhoneNo());
             preparedStatement.setString(5, chequebookReq.getEmail());
             preparedStatement.setString(6, chequebookReq.getDate());
             preparedStatement.setString(7, chequebookReq.getAccountType());
             preparedStatement.setString(8, chequebookReq.getBankName());
             preparedStatement.setString(9, chequebookReq.getAccountNumber());
             preparedStatement.setString(10, chequebookReq.getPin());
             preparedStatement.setString(11, chequebookReq.getStartingChequeno());
             preparedStatement.setString(12, chequebookReq.getEndingChequeno());
             preparedStatement.setString(13, chequebookReq.getLeaves());


            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
           } catch (SQLException e) {
              e.printStackTrace();
              return false;

           }finally {
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
