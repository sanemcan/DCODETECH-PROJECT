package com.dcodetech.ATMMACHINE.dao;

import com.dcodetech.ATMMACHINE.dbutils.DBUtils;
import com.dcodetech.ATMMACHINE.pojo.AccountCreation;
import com.dcodetech.ATMMACHINE.pojo.Changephn;
import com.dcodetech.ATMMACHINE.pojo.ChequebookReq;
import com.dcodetech.ATMMACHINE.pojo.EmailService;
import com.dcodetech.ATMMACHINE.pojo.MoneyTransfer;
import com.dcodetech.ATMMACHINE.pojo.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class Userdao {

    // ! METHOD FOR SAVING ACCOUNT DETAILS
    public boolean saveAccountDetails(AccountCreation accountCreation) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            String query = "INSERT INTO account_details (account_type, bank_name, first_name, middle_name, last_name, date_of_birth, age, phone_no, email, aadhar_card_no, pin, passport_photograph,status,balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

    // ! METHOD FOR CHECKING DOES ACCOUNT ID EXISTS OR NOT
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

    // ! METHOD FOR STORING REGISTRATION DETAILS AND SENDING EMAIL
    private final EmailService emailService;

    @Autowired
    public Userdao(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean saveRegisterDetails(Register register) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            if (isEmailOrUsernameExists(register.getEmail(), register.getUsername())) {
                System.out.println("Error: Email or username already exists.");
                return false;
            }

            String originalPassword = register.getPassword(); //prachi@219

            // Hash the password using SHA256
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(register.getPassword()); //ithe fakt password pass kela aapn mhnun fakt password hash hotoy baki kay nay
            register.setPassword(hashedPassword);   // ithe prachi@219 ha password hash jhala fakt  

            String query = "INSERT INTO register_details (firstname,lastname,email,username,password) VALUES(?,?,?,?,?)";   // ithe ? chya jagi hash wala jael password
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, register.getFirstname());
            preparedStatement.setString(2, register.getLastname());
            preparedStatement.setString(3, register.getEmail());
            preparedStatement.setString(4, register.getUsername());
            preparedStatement.setString(5, register.getPassword());  //prachi@219 ===> hash jhalela asel tithe

            // Continue with the registration process
            boolean success = preparedStatement.executeUpdate() > 0;

            if (success) {
                // Send registration confirmation email with all details
                emailService.sendRegistrationConfirmation(register, originalPassword);
            }

            return success;
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

    // ! METHOD TO CHECK EMAIL AND USERNAME ALREADY EXISTS OR NOT
    public boolean isEmailOrUsernameExists(String email, String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.openConnection();

            // Check if email exists
            String emailQuery = "SELECT * FROM register_details WHERE email=?";
            preparedStatement = connection.prepareStatement(emailQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

            // Check if username exists
            String usernameQuery = "SELECT * FROM register_details WHERE username=?";
            preparedStatement = connection.prepareStatement(usernameQuery);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

            // No matching email or username found
            return false;
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

    // ! METHOD FOR GETTING TRANSACTION HISTORY DETAILS OF PARTICULAR ACCOUNT ID
    public List<MoneyTransfer> getTxnHistoryByAccountId(int accid) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<MoneyTransfer> txnHistoryList = new ArrayList<>();

        try {
            connection = DBUtils.openConnection();
            String query = "SELECT * FROM money_transfer WHERE account_number = ? OR recipient_account_no = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, accid);
            preparedStatement.setInt(2, accid);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MoneyTransfer txnHistory = new MoneyTransfer();
                txnHistory.setAccountnumber(resultSet.getString("account_number"));
                txnHistory.setRecipientaccountnumber(resultSet.getString("recipient_account_no"));
                txnHistory.setTransactionammount(resultSet.getString("transaction_amount"));
                txnHistory.setPhoneno(resultSet.getString("phone_no"));
                txnHistory.setDate(resultSet.getString("txn_date"));
                txnHistory.setStatus(resultSet.getString("status"));

                txnHistoryList.add(txnHistory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

        return txnHistoryList;
    }

    // ! METHOD FOR CHECKING DOES USERNAME OR PASSWORD MATCH FOR LOGIN
    public boolean usernamePassword(String uname, String pass) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            String query = "SELECT password FROM register_details WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the hashed password from the database
                String hashedPasswordFromDB = resultSet.getString("password");

                // Use BCrypt to check if the entered password matches the hashed one
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                return encoder.matches(pass, hashedPasswordFromDB);
            }

            return false;
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

    // ! WE ARE GETTING USER DETAILS WHO IS LOGGIGN IN
    public Register getUserDetailsByUsername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.openConnection();
            String query = "SELECT * FROM register_details WHERE username=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Register user = new Register();
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmailid(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }

            return null; // Return null if user not found
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

    // ! CHEQUE REQUEST PAGE
    @Autowired
    Pindao pindao;

    public boolean ChequebookReqDeatils(ChequebookReq chequebookReq) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();

            String query = "  INSERT INTO chequebook_req (first_name,middle_name,last_name,phone_no,email,date_of_req,account_type,bank_name,account_number,starting_chequq_no,ending_chequq_no,leaves,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(10, chequebookReq.getStartingcheque());
            preparedStatement.setString(11, chequebookReq.getEndingcheque());
            preparedStatement.setString(12, chequebookReq.getLeaves());
            preparedStatement.setString(13, "pending");

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

    // ! CHANGE PHONE NUMBER
    public boolean savePhnNumberUpadteDetails(Changephn changephn) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            String query = "UPDATE  account_details SET phone_no  = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, changephn.getPhoneNo());
            preparedStatement.setString(2, changephn.getAccountnumber());

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
