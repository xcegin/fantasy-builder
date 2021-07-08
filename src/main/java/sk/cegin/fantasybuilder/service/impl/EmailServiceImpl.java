package sk.cegin.fantasybuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sk.cegin.fantasybuilder.service.api.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Override
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    //TODO: Change for real id
    public void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom(mailFrom);
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8887/user/confirm?token="
                        + token);

        sendEmail(mailMessage);
    }
}
