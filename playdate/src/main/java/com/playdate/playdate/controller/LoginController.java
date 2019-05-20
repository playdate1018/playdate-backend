package com.playdate.playdate.controller;

import com.playdate.playdate.model.request.LoginVerificationRequest;
import com.playdate.playdate.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/playdate")
@Validated
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    //TODO: Add validations
    @PostMapping("/login/verification")
    public void loginUser(@RequestBody @Valid LoginVerificationRequest loginVerificationRequest){
        Boolean loginVerification = loginService.loginUser(loginVerificationRequest);

        //TODO: think about exception handling(check getMessages for exceptional handling), and business logic and what should be returned to the UI
        if(loginVerification)
            System.out.println("LoginVerificationSuccessful");
        else
            System.out.println("Please provide correct username and password");
    }

    @PostMapping("/forgotpassword")
    public void forgotPassword(@RequestBody @Valid LoginVerificationRequest loginVerificationRequest){
        Boolean changePassword = loginService.changePassword(loginVerificationRequest);

        if(changePassword)
            System.out.println("Password changed successfully");
        else
            System.out.println("Unable to update the password");
    }

}
