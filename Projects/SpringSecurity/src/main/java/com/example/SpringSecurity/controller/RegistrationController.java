package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.entity.VerificationToken;
import com.example.SpringSecurity.event.RegistrationCompleteEvent;
import com.example.SpringSecurity.model.dto.PasswordDto;
import com.example.SpringSecurity.model.dto.UserDto;
import com.example.SpringSecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Zulfa Attar
 */
@Slf4j
@RestController
public class RegistrationController {

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody UserDto userDto, final HttpServletRequest request){

        User user = userService.registerUser(userDto);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        if(user!= null){
            return "Success";
        }else
            return "Failed";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = userService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid")){
            return "User Verified Successfully";
        }
        return "Bad User";
    }

    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest request){
        VerificationToken verificationToken
                 = userService.generateNewVerificationToken(oldToken);

        User user = verificationToken.getUser();
        resendVerificationTokenMail(user, applicationUrl(request), verificationToken);

        return "Verification Link Sent";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordDto passwordDto, HttpServletRequest request){
        User user = userService.findUserByEmail(passwordDto.getEmail());

        String url = "";
        if(user!= null){
            String token  = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            url = passwordResetTokenMail(user, applicationUrl(request),  token);
        }
        return "Password Reset Mail Sent";
    }


    @PostMapping("/savePassword")
    public String savePassword(@RequestParam("token") String token,
                        @RequestBody PasswordDto passwordDto){
        String result = userService.validatePasswordResetToken(token);
        if(!result.equalsIgnoreCase("valid")){
            return "Invalid token";
        }
        Optional<User> user = userService.getUserByPasswordResetToken(token);
        if(user.isPresent()){
            userService.changePassword(user.get(), passwordDto.getNewPassword());
            return "Password Reset Successful";
        }else {
            return "Invalid Token";
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody PasswordDto passwordDto){
        User user = userService.findUserByEmail(passwordDto.getEmail());
        if(!userService.checkIfValidOldPassword(user, passwordDto.getOldPassword())){
            return new ResponseEntity("Invalid User", HttpStatus.NOT_ACCEPTABLE);
        }

        //save new password
        userService.changePassword(user, passwordDto.getNewPassword());
        return new ResponseEntity("Password Changed Successfully", HttpStatus.OK);
    }

    private String passwordResetTokenMail(User user, String applicationUrl, String token) {
        String url = applicationUrl + "/savePassword?token="
                + token;
        log.info("Click the link to verify your account: {}", url);
        return url;
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {

        String url = applicationUrl + "/verifyRegistration?token="
                + verificationToken.getToken();
        log.info("Click the link to verify your account: {}", url);

    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+
                request.getServerName() + ":"+
                request.getServerPort() +
                request.getContextPath();
    }
}
