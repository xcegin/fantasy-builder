package sk.cegin.fantasybuilder.service.api;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage email);
    void sendConfirmationMail(String userMail, String token);
}
