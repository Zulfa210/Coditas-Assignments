package com.example.Email_System.service;

import com.example.Email_System.entity.MailContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Zulfa Attar
 */

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(MailContents mailContents) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("zulfaattar@gmail.com");
        message.setTo(mailContents.getToEmail());
        message.setText(mailContents.getBody());
        message.setSubject(mailContents.getSubject());


        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    public void sendEmailWithAttachment(MailContents mailContents) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("zulfaattar@gmail.com");
        mimeMessageHelper.setTo(mailContents.getToEmail());
        mimeMessageHelper.setText(mailContents.getBody());
        mimeMessageHelper.setSubject(mailContents.getSubject());


        FileSystemResource fileSystem
                = new FileSystemResource(new File(mailContents.getFilePath()));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");

    }
}
