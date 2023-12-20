package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.dbutils;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;
@Component
public class Userdao {
      
    // ata yat method banva 
    public boolean  saveAccountDetails(AccountCreation accountCreation){
         Connection connection = null;
         PreparedStatement preparedStatement=null;


//insert,update,delete ,select frontend cha dhakvla
         try{
            connection = dbutils.openConnection();
            String query = "INSERT INTO account_details(account_type,bank_name,first_name,middle_name,last_name,date_of_birth,age,phone_no,email,aadhar_card_no,pin,passport_photograph,status)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
               
            //preparedstatement
            preparedStatement= connection.prepareStatement(query);
           //java madhe method name eka class madhe asto ti ata method dusra folder class madhe call  call karynayasathi apn classname.method name asa lihto tasach he asta .
           // yat connection ha classname ahe and preparedstatement hi metho ahe


          preparedStatement.setString(1,accountCreation.getAccountType());
          preparedStatement.setString(2,accountCreation.getBankName());
          preparedStatement.setString(3,accountCreation.getFirstName());
          preparedStatement.setString(4,accountCreation.getMiddleName());
          preparedStatement.setString(5,accountCreation.getLastName());
          preparedStatement.setString(6,accountCreation.getDateOfBirth());
          preparedStatement.setInt(7,accountCreation.getAge());
          preparedStatement.setString(8,accountCreation.getPhoneNo());
          preparedStatement.setString(9,accountCreation.getEmail());
          preparedStatement.setString(10,accountCreation.getAadharCardNo());
          preparedStatement.setString(11,accountCreation.getPin());
          preparedStatement.setString(12,accountCreation.getPassportPhotograph());
          preparedStatement.setString(13,"pending");
          
          
          //he check  karyansathi ahe query run jhlyavar data insert jhlya ki nhi te baghyla   database madhe
          int rowsAffected = preparedStatement.executeUpdate();
          return rowsAffected > 0;  // varti method ahe save account detaill tyala return pahije mahun dile 
                                    // apla result 1or 0 madhe yeil mahnun greter than 0 manjhe 1 true ahe jar 0 ala tr false
         }catch(SQLException e){
              //e mahnun denote kelya sqlexception la

              e.printStackTrace(); //aple error exception print karyla lihtat 

              return false;
         }finally{
            try{
                if(preparedStatement != null) //
                preparedStatement.close();
                dbutils.closeconnection();   
           }catch (SQLException e){
            e.printStackTrace();
           }
    }
     

    }
}
