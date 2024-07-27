package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String toEmail,String subject,String body) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("lapaix.dev@gmail.com");
        javaMailSender.send(message);
        

    }
}
