package com.example.Email_System.entity;

import lombok.Data;

/**
 * @author Zulfa Attar
 */
@Data
public class MailContents {
    String toEmail;
    String body;
    String subject;
    String filePath;
}
