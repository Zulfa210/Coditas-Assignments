package com.example.Email_System;

import com.example.Email_System.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailSystemApplication {

//	@Autowired
//	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(EmailSystemApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//
//		service.sendEmailWithAttachment("aarti.dhumal@coditas.com",
//				"This is Email Body with Attachment...",
//				"This email has attachment",
//				"C:\\Users\\shabb\\Pictures\\c.gif");
//
//	}

}
