package com.playdate.playdate.controller;

import com.mongodb.MongoClient;
import com.playdate.playdate.model.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playdate/update")
@Validated
@RequiredArgsConstructor
public class UserDetailsController {
    private final MongoOperations mongoOperations;

    @PostMapping("/userdetails")
    public boolean updateUserDetails(@RequestBody UserDetails userDetails){
        Boolean updated = false;
        mongoOperations.save(userDetails);
        return updated;
    }
}
