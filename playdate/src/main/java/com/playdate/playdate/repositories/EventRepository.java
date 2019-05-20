package com.playdate.playdate.repositories;

import com.playdate.playdate.model.EventDetails;
import com.playdate.playdate.model.UserDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "eventDetails", path = "eventDetails")
public interface EventRepository extends MongoRepository<EventDetails,String> {

    EventDetails findByEmail(String email);
    EventDetails findByPlayDateOn(String playDateOn);

}
