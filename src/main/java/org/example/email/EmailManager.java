package org.example.email;

public class EmailManager {

    private EmailService emailService;

    public EmailManager(EmailService emailService){
        this.emailService = emailService;
    }

    public void sendWelcomEmail(String to){
        emailService.sendEmail(to, "Welcome!", "Welcome to our plataform.");
    }

}
