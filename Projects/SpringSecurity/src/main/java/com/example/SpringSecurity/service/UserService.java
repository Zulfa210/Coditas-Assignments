package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.entity.VerificationToken;
import com.example.SpringSecurity.model.dto.UserDto;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
public interface UserService {
    User registerUser(UserDto userDto);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
