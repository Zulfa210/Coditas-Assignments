package com.example.JwtAuthentication.request;

import lombok.Data;

/**
 * @author Zulfa Attar
 */
@Data
public class JwtRequest {
    private String userEmail;
    private String password;
}
