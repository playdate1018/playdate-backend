package com.playdate.playdate.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class LoginVerificationRequest {

    @Email
    public String email;
    public String password;
    public String username;
}
