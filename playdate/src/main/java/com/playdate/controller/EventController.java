package com.playdate.controller;

import com.playdate.model.UserDetails;
import com.playdate.model.EventDetails;
import com.playdate.repositories.EventRepository;
import com.playdate.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/playdate")
@RequiredArgsConstructor
public class EventController {

    private final MongoOperations mongoOperations;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @PostMapping("/createEvent")
    public void createEvent(@RequestBody EventDetails eventDetails){
        UserDetails userDetails = userRepository.findByEmail(eventDetails.getEmail());

        if (userDetails == null) throw new ResourceNotFoundException();

        eventDetails.setId(userDetails.getId());
        eventDetails.setPlayDateCreatedOn(LocalDateTime.now());
        mongoOperations.save(eventDetails);
    }

    @GetMapping("/upcomingEvents/{from}/{to}")
    public void getUpcomingEvents(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime from, @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime to){
       List<EventDetails> eventDetails = eventRepository.findEventDetailsByDateBetween(from,to);
    }

    @GetMapping("/createdEvents/{from}/{to}")
    public void getCreatedEvents(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime from, @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime to){
        List<EventDetails> eventDetails = eventRepository.findEventDetailsByDateCreatedBetween(from,to);
    }

}
