package com.playdate.controller;

import com.playdate.model.Event;
import com.playdate.model.EventDetails;
import com.playdate.model.UserDetails;
import com.playdate.repositories.EventRepository;
import com.playdate.repositories.UserRepository;
import com.playdate.service.ProfileDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/playdate")
@Validated
@RequiredArgsConstructor
public class UserDetailsController {

    @Autowired
    ProfileDetails profileDetails;
    private final MongoOperations mongoOperations;
    private final EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userdetails/{email}")
    public UserDetails getUserDetails(@PathVariable String email){
        UserDetails userDetails = userRepository.findByEmail(email);
        return userDetails;
    }

    @PostMapping("/update/userdetails")
    public boolean updateUserDetails(@RequestBody UserDetails userDetails){
        Boolean updated = false;
        mongoOperations.save(userDetails);
        return updated;
    }

    @GetMapping("getAllUsers")
    public List<String> getAllUsers(){

        return userRepository.findAll().stream()
                .map(e -> e.getEmail())
                .collect(Collectors.toList());

    }

    @GetMapping("getNearByUsers")
    public List<UserDetails> getNearByUsers(){
        //TODO: do not allow to send a play request to the same person more than once
        return mongoOperations.findAll(UserDetails.class);
    }

    @GetMapping("/getPlayDatesCreatedBy/{email}")
    public List<EventDetails> getPlayDatesCreatedBy(@PathVariable String email){
        List<EventDetails>eventDetails = eventRepository.findByCreatedBy(email);
        return eventDetails;
    }
}
