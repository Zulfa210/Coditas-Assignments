package com.example.SpringSecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zulfa Attar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userEmail;
    private String matchingPassword;
}
