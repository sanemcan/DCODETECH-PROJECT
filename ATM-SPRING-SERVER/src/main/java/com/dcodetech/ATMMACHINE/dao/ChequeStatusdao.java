package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;


@Component  
public class ChequeStatusdao {
    

     @Autowired
    Pindao pindao;

    public List<ChequebookReq> getAllChequebookRequests() {
        List<ChequebookReq> chequebookRequests = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();

            String query = "SELECT * FROM chequebook_req";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ChequebookReq chequebookReq = new ChequebookReq();
                chequebookReq.setAccountnumber(resultSet.getInt("account_number"));
                chequebookReq.setFirstname(resultSet.getString("first_name"));
                chequebookReq.setLastname(resultSet.getString("last_name"));
                

                // Add more fields as needed

                chequebookRequests.add(chequebookReq);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                DBUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return chequebookRequests;
    }
}
