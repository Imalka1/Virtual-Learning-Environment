package lk.ijse.vle.utilities;

import lk.ijse.vle.dto.EmailDTO;
import lk.ijse.vle.dto.PostgraduateDetailsDTO;
import lk.ijse.vle.dto.UndergraduateDetailsDTO;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EmailService {

    private String url;
    private static EmailService emailService;

    public static EmailService getEmailService() {
        if (emailService == null) {
            emailService = new EmailService();
        }
        return emailService;
    }

    private EmailService() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("settings.properties").getFile());
        Properties properties = new Properties();
        FileReader inputStream = null;
        try {
            System.out.println(file);
            inputStream = new FileReader(file);
            properties.load(inputStream);
            url = properties.getProperty("urlForEmail");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EmailDTO sendEmail(String number, UndergraduateDetailsDTO undergraduateDetailsDTO, String regId, String studentId) {
        EmailDTO email = new EmailDTO();
        String text = "Thank you\n\n" + undergraduateDetailsDTO.getRegistration().getStudent().getTitle() + "." + undergraduateDetailsDTO.getRegistration().getStudent().getNameWithInitials() + "\n\nYou are now successfully registered as a new student with learning management system.\n\nNote:- Now you can login as a student with the system.\nNote:- Password, Student ID and Registration ID(system generated) are attached with this email.\nNote:- Use your Student ID or email as the username and the given password to login.\nNote:- After login, you can change your password.\n\nRegistration ID:- " + regId + "\nStudent ID:- " + studentId + "\nPassword:- " + number;
        String emailAddress = undergraduateDetailsDTO.getRegistration().getStudent().getEmail();
        String subject = "System registration";
        email.setReply(sendMail(text, emailAddress, subject));
        return email;
    }

    public EmailDTO sendEmail(String number, PostgraduateDetailsDTO postgraduateDetailsDTO, String regId, String studentId) {
        EmailDTO email = new EmailDTO();
        String text = "Thank you\n\n" + postgraduateDetailsDTO.getRegistration().getStudent().getTitle() + "." + postgraduateDetailsDTO.getRegistration().getStudent().getNameWithInitials() + "\n\nYou are now successfully registered as a new student with learning management system.\n\nNote:- Now you can login as a student with the system.\nNote:- Password(system generated) has been sent to your given email address.\nNote:- Use your Student ID or email as the username and the given password for the login.\nNote:- After login, you can change your password.\n\nRegistration ID:- " + regId + "\nStudent ID:- " + studentId + "\nPassword:- " + number + "\n\nClick to login:- " + url + "";
        String emailAddress = postgraduateDetailsDTO.getRegistration().getStudent().getEmail();
        String subject = "System registration";
        email.setReply(sendMail(text, emailAddress, subject));
        return email;
    }

    public EmailDTO emailForgotPassword(EmailDTO emailDTO) {
        EmailDTO email = new EmailDTO();
        String text = "Your verification code is : " + emailDTO.getVerNumber();
        String emailAddress = emailDTO.getEmailAddress();
        String subject = "Login Verification";
        email.setReply(sendMail(text, emailAddress, subject));
        return email;
    }

    private String sendMail(String text, String emailAddress, String subject) {
        String reply = "";
        try {
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");

            Authenticator auth = new EmailService.SMTPAuthenticator("webphpjava@gmail.com", "webphpjava1");

            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(text);
            msg.setSubject(subject);

            msg.setFrom(new InternetAddress("webphpjava@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            Transport.send(msg);

        } catch (AuthenticationFailedException ex) {
            reply = "Authentication failed";
            return reply;
        } catch (AddressException ex) {
            reply = "Invalid email address";
            return reply;
        } catch (MessagingException ex) {
            reply = "Cannot Send Email";
            return reply;
        }
        reply = "Email has been sent successfully";
        return reply;
    }

    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
}
