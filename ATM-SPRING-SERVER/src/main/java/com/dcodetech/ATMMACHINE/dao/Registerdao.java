package com.dcodetech.ATMMACHINE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;
import com.dcodetech.ATMMACHINE.pojo.AccountService;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;
import com.dcodetech.ATMMACHINE.pojo.Register;

@Component
public class Registerdao {
        public boolean saveRegisterDetails(Register register) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            if(findByUsernameOrByEmail(register.getUsername(),register.getEmail())){
                System.out.println("Email or username already exists");
                return false;
            }
            String query = "INSERT INTO Register_Table (first_name, last_name, email, username, userpassword) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, register.getFirstName());
            preparedStatement.setString(2, register.getLastName());
            preparedStatement.setString(3, register.getEmail());
            preparedStatement.setString(4, register.getUsername());
            preparedStatement.setString(5, register.getPassword());
           
            
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

    
    public boolean findByUsernameOrByEmail(String username, String email) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = DBUtils.openConnection();
        String query = "SELECT * FROM Register_Table WHERE username= ? OR email = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);
        
        // Use executeQuery instead of executeUpdate for SELECT queries
        resultSet = preparedStatement.executeQuery();

        // Check if any rows are returned
        return resultSet.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            DBUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//  private void sendRegistrationConfirmationEmail(Register register) {
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(register.getEmail());
//         message.setSubject("Registration Confirmation");

//          Register rg= new register()
//         context.setUsername("username", register.getUsername());
//         context.setFirstname("firstName", register.getFirstName());
//         context.setLastname("lastName", register.getLastName());
//         context.setEmail("email", register.getEmail());

//         String emailContent = templateEngine.process("registration-email-template", context);
//         message.setText(emailContent);

//         mailSender.send(message);
//     }
    

    
}
