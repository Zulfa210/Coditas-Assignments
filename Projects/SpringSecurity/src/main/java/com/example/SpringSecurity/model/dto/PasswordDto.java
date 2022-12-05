package com.example.SpringSecurity.model.dto;

import lombok.Data;

/**
 * @author Zulfa Attar
 */
@Data
public class PasswordDto {
    private String email;
    private String oldPassword;
    private String newPassword;

}
