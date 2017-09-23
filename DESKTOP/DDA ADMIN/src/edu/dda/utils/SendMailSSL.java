package edu.dda.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailSSL {

    public static void sendMail(String to, String subject, String msg) {
        String email = null;
//
//        final String from = "odssconnect@gmail.com";
//        final String passwd = "odssconnect123456";
         to =  email;
        final String from = "odssconnect@gmail.com";

        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "odssconnect123456");
                    }
                });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(msg);

            //send message  
            Transport.send(message);

            System.out.println("message sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        SendMailSSL s = new SendMailSSL();
//  s.sendMail("deepesh.nair45@gmail.com", "kk");
       s.sendMail("annaneesh10@gmail.com", "kk");

    }

    private void sendMail(String annaneesh10gmailcom, String kk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
