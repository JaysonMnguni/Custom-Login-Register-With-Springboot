package com.application_demo.springmvc_custom_authentication.messenger;

import com.application_demo.springmvc_custom_authentication.config.MailConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailMessenger {

    public static void htmlEmailMessenger(String fromMail, String toMail, String subject, String body) throws MessagingException {
        // Get Mail Config:
        JavaMailSender sender = MailConfig.getMailConfig();
        // Set Mime Message:
        MimeMessage message = sender.createMimeMessage();

        // Set Mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);

        // Set Mail Attributes:
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(fromMail);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body, true);
        // Send Message / Mail:
        sender.send(message);
    }
    // End Of Mail Sender / Messenger Method.
}
