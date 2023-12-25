// package com.dcodetech.ATMMACHINE.pojo;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;
// // import org.thymeleaf.spring6.SpringTemplateEngine;
// import org.springframework.ui.context.support.SpringTemplateEngine;

// import com.dcodetech.ATMMACHINE.dao.Registerdao;
// import com.dcodetech.ATMMACHINE.dbutils.DBUtils;

// import org.thymeleaf.context.Context;



// @Service
// public class RegisterService {
//     private final Registerdao registerdao;
    
//     private final JavaMailSender mailSender;
//     private final SpringTemplateEngine templateEngine;

// //contructor kela
// @Autowired
// public RegisterService(Registerdao registerdao, 
// JavaMailSender mailSender, SpringTemplateEngine templateEngine) 
// {
// this.registerdao = registerdao;
// this.mailSender = mailSender;
// this.templateEngine = templateEngine;
// }

// // Send registration confirmation email
// public boolean registerUser(Register register) {

//   // Send registration confirmation email
//   sendRegistrationConfirmationEmail(register);

//   // Other registration logic

//   return true;

// }

// private void sendRegistrationConfirmationEmail(Register register) {
//     SimpleMailMessage message = new SimpleMailMessage();
//     message.setTo(register.getEmail());
//     message.setSubject("Registration Confirmation");
    
//     Context context = new Context();
//     context.setVariable("username", register.getUsername());
//     context.setVariable("firstName", register.getFirstName());
//     context.setVariable("lastName", register.getLastName());
//     context.setVariable("email", register.getEmail());
    
//     String emailContent = templateEngine.process("registration-email-template", context);
//     message.setText(emailContent);
    
//     mailSender.send(message);
    
// }

// }
    
    