package com.playdate.controller;

import com.playdate.model.UserDetails;
import com.playdate.repositories.UserRepository;
import com.playdate.service.RegistrationService;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/playdate")
@Validated
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    private UserRepository userRepository;

    //TODO: Add validations
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserDetails userDetails){
        Response response=null;
        String status="failure";

        if (userRepository.findByEmail(userDetails.getEmail())==null)
            response = registrationService.registerUser(userDetails);

        if(response!=null) {
            if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                System.out.println(response.getStatusCode());
                status = "success";
            }
        }
        return status;
    }
}
