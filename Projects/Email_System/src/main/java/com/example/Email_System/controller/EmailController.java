package com.example.Email_System.controller;

import com.example.Email_System.entity.MailContents;
import com.example.Email_System.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zulfa Attar
 */
@RestController
public class EmailController {

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping("/sendMail")
    public ResponseEntity sendEmail(@RequestBody MailContents mailContents){
        try{
            emailSenderService.sendSimpleEmail(mailContents);
            return new ResponseEntity("Mail Send", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sendMailWithFile")
    public ResponseEntity sendEmailWithAttachment(@RequestBody MailContents mailContents){
        try{
            emailSenderService.sendEmailWithAttachment(mailContents);
            return new ResponseEntity("Mail send", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
