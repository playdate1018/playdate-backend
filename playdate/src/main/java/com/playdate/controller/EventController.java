package com.playdate.controller;

import com.playdate.model.*;
import com.playdate.repositories.EventRepository;
import com.playdate.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;


//@CrossOrigin(origins = "*", allowedHeaders = "Access-Control-Allow-Origin")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/playdate")
public class EventController {

    private final MongoOperations mongoOperations;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @PostMapping("/newEvent/{createdBy}")
    public String createEvent(@PathVariable String createdBy, @RequestBody Event event){
        System.out.println("Event is created by: "+createdBy);

        String eventId = String.valueOf(UUID.randomUUID().toString());
        EventDetails eventDetails = EventDetails.builder()
                .eventGuid(eventId)
                .createdBy(createdBy)
                .when(event.getWhen())
                .where(event.getWhere())
                .description(event.getDescription()).build();

        eventRepository.save(eventDetails);
        return eventDetails.getEventGuid();
    }

    @GetMapping("/requestResponse/{eventGuid}/{email}/{status}")
    public void respondingToRequest(@PathVariable String eventGuid, @PathVariable String email, @PathVariable String status){
        EventDetails eventDetails = eventRepository.findByEventGuid(eventGuid);
        System.out.println("wait!");

        System.out.println("wait!");
        eventDetails.getParticipants().stream().filter(participant -> participant.getEmail().equals(email)).forEach(p->p.setStatus(status));
        eventRepository.save(eventDetails);
    }

    @GetMapping("/sendRequest/{eventGuid}/{sendRequestTo}")
    public void sendRequest(@PathVariable String eventGuid, @PathVariable String sendRequestTo){
        EventDetails eventDetails = eventRepository.findByEventGuid(eventGuid);

        if(eventDetails.getParticipants()!=null){
            if(eventDetails.getParticipants().stream().filter(participant -> participant.getEmail().equals(sendRequestTo)).count()>0){
                System.out.println("exception because this user has already been sent the request");
            }
            else{
                eventDetails.getParticipants().add(Participant.builder().email(sendRequestTo).status("REQUESTED").build());
            }
        }

        if(eventDetails.getParticipants()==null){
            List<Participant> participantsList = new ArrayList<>();
            participantsList.add(Participant.builder().email(sendRequestTo).status("REQUESTED").build());
            eventDetails.setParticipants(participantsList);
        }
        eventRepository.save(eventDetails);
    }


    @GetMapping("/upcomingEvents/{email}/{status}")
    public List<UpcomingEvent> upcomingEvents(@PathVariable String email, @PathVariable String status){
        List<EventDetails>eventDetails = eventRepository.findAll();
        List<UpcomingEvent> upcomingEvents = new ArrayList<>();

        for(int i=0;i<eventDetails.size();i++){
            System.out.println("iterating: "+i);

            if(eventDetails.get(i).getParticipants()!=null){
                if(eventDetails.get(i).getParticipants().stream().filter(participant -> participant.getEmail().equals(email) && participant.getStatus().equals(status)).collect(Collectors.toList()).size()==1){
                    if(eventDetails.get(i).getParticipants().stream().filter(participant -> participant.getStatus().equals(status)).collect(Collectors.toList()).size()>0){
                        Participant participantObj = eventDetails.get(i).getParticipants().stream().filter(
                                participant ->
                                        participant.getEmail().equals(email)
                                                && participant.getStatus().equals(status)).collect(Collectors.toList()).get(0);
                        upcomingEvents.add(UpcomingEvent.builder().eventGuid(eventDetails.get(i).getEventGuid()).when(eventDetails.get(i).getWhen()).where(eventDetails.get(i).getWhere()).status(participantObj.status).description(eventDetails.get(i).getDescription()).build());
                    }
                }
            }
        }
        return upcomingEvents;
    }
    @GetMapping("/upcomingEvents/{email}")
    public List<EventDetails> createdBy(@PathVariable String email) {
        List<EventDetails> eventDetails = eventRepository.findByCreatedBy(email);
        return eventDetails;
    }

    @GetMapping("/viewEventDetails/{eventGuid}")
    public EventDetails viewEventDetails(@PathVariable String eventGuid){
       return eventRepository.findByEventGuid(eventGuid);
    }

    @GetMapping("/playdatesCreatedBy/{email}")
    public List<EventDetails> playdatesCreatedBy(@PathVariable String email){
        return eventRepository.findByCreatedBy(email);
    }
        public static int getRandomNumber(){
        return new Random().nextInt(1000);
    }

}