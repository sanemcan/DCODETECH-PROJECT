package com.dcodetech.ATMMACHINE.pojo;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationConfirmation(Register register,String originalPassword) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        try {
            helper.setSubject("Registration Confirmation");

            // HTML content for the email template
            String htmlContent = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto;'>"
                    + "<p style='font-size: 18px; color: #333;'><strong>Dear " + register.getUsername()
                    + ",</strong></p>"
                    + "<p style='font-size: 16px; color: #555;'>Thank you for registering with our service!</p>"
                    + "<div style='background-color: #f8f8f8; padding: 20px; margin-top: 15px;'>"
                    + "<p style='font-size: 16px; color: #333;text-align:centre'><strong>Details:</strong></p>"
                    + "<ul style='list-style-type: none; padding: 0;'>"
                    + "<li style='margin-bottom: 10px;'><strong>First Name:</strong> " + register.getFirstname()
                    + "</li>"
                    + "<li style='margin-bottom: 10px;'><strong>Last Name:</strong> " + register.getLastname() + "</li>"
                    + "<li style='margin-bottom: 10px;'><strong>Email:</strong> " + register.getEmail() + "</li>"
                    + "<li style='margin-bottom: 10px;'><strong>Username:</strong> " + register.getUsername() + "</li>"
                    + "<li style='margin-bottom: 10px;'><strong>Password:</strong> " + originalPassword + "</li>"
                    + "</ul>"
                    + "<p style='font-size: 14px; color: #555;'>Thank you for choosing our service. We look forward to serving you!</p>"
                    + "<div style='text-align: center;'>"
                    + "<img src='#' alt='Company Logo' style='max-width: 100px; margin-top: 20px;' />"
                    + "<p style='font-size: 12px; color: #888; margin-top: 10px;'>© 2023 DcodeTech. All rights reserved.</p>"
                    + "</div>"
                    + "</div>"
                    + "</div>";

            helper.setText(htmlContent, true); // true indicates HTML content

            helper.setTo(register.getEmail());

            javaMailSender.send(message);
        } catch (MessagingException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }
}
