package com.playdate.controller;

import com.playdate.model.UserDetails;
import com.playdate.service.ProfileDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/playdate")
@Validated
@RequiredArgsConstructor
public class UserDetailsController {

    @Autowired
    ProfileDetails profileDetails;
    private final MongoOperations mongoOperations;

    @PostMapping("/update/userdetails")
    public boolean updateUserDetails(@RequestBody UserDetails userDetails){
        Boolean updated = false;
        mongoOperations.save(userDetails);
        return updated;
    }


    @GetMapping("/userdetails/{email}")
    public UserDetails updateUserDetails(@PathVariable String email){
        return profileDetails.getProfileDetails(email);
    }

}
