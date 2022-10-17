package com.example.CarPassengerManagementSystem.entities;

/**
 * @author Zulfa Attar
 */
public class JwtResponse {
    private String token;

    public JwtResponse() {
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
