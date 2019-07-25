package com.playdate.service;

import com.playdate.model.UserDetails;
import com.playdate.model.request.LoginVerificationRequest;
import com.playdate.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileDetails {
    private final MongoOperations mongoOperations;

    private final UserRepository userRepository;
    public UserDetails getProfileDetails(String email){
        UserDetails userDetails = userRepository.findByEmail(email);
        return userDetails;
    }
}
