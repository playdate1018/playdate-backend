package com.playdate.playdate.repositories;

import com.playdate.playdate.model.EventDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "eventDetails", path = "eventDetails")
public interface EventRepository extends MongoRepository<EventDetails,String> {

    EventDetails findByEmail(String email);
    EventDetails findByPlayDateOn(String playDateOn);

    @Query("{ 'playDateOn' : {$gte: ?0, $lt:?1}}")
    List<EventDetails> findEventDetailsByDateBetween(LocalDateTime from, LocalDateTime to);

    @Query("{ 'playDateCreatedOn' : {$gte: ?0, $lt:?1}}")
    List<EventDetails> findEventDetailsByDateCreatedBetween(LocalDateTime from, LocalDateTime to);
}
