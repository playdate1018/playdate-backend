package com.playdate.playdate.service;

import com.mongodb.MongoClient;
import com.playdate.playdate.model.UserDetails;
import com.playdate.playdate.model.request.LoginVerificationRequest;
import com.playdate.playdate.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MongoOperations mongoOperations;

    private final UserRepository userRepository;

    public Boolean loginUser(LoginVerificationRequest loginVerificationRequest){
        //TODO: how do you handle when the email id in the url is not present in database
        Boolean validation = false;
        UserDetails userDetails = userRepository.findByEmailAndPassword(loginVerificationRequest.getEmail(), loginVerificationRequest.getPassword());
        if(userDetails!=null)
            validation = true;

        return validation;
    }

    public Boolean changePassword(LoginVerificationRequest loginVerificationRequest){
        UserDetails userDetails = userRepository.findByEmail(loginVerificationRequest.getEmail());

        //TODO: add login to verify if it is the correct person that is trying to change the password. eg: send security code to hi/her mobile

        userDetails.setPassword(loginVerificationRequest.getPassword());

        mongoOperations.save(userDetails);
        return true;
    }

}
