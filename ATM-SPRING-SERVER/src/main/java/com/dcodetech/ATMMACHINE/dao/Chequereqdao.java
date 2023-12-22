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

             preparedStatement.setString(1, chequebookReq.getFirstname());
             preparedStatement.setString(2, chequebookReq.getMiddlename());
             preparedStatement.setString(3, chequebookReq.getLastname());
             preparedStatement.setString(4, chequebookReq.getPhoneno());
             preparedStatement.setString(5, chequebookReq.getEmailid());
             preparedStatement.setString(6, chequebookReq.getDate());
             preparedStatement.setString(7, chequebookReq.getAccounttype());
             preparedStatement.setString(8, chequebookReq.getBankname());
             preparedStatement.setString(9, chequebookReq.getAccountnumber());
             preparedStatement.setString(10, chequebookReq.getPin());
             preparedStatement.setString(11, chequebookReq.getStartingcheque());
             preparedStatement.setString(12, chequebookReq.getEndingcheque());
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
