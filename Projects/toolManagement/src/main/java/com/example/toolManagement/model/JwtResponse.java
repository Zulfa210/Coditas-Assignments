package com.example.toolManagement.model;
/**
 * @author Zulfa Attar
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String jwtToken;
    private String userRole;
    private Long userId;
}