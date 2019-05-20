package com.playdate.playdate.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@Document
public class EventDetails {

    //TODO: generate an automatic unique id
    @org.springframework.data.annotation.Id
    int Id;

    @Indexed(unique = true)
    String email;

    //TODO: make these to Date data type
    String playDateCreatedOn;
    String playDateOn;
    HashMap<String, Boolean> responded;

    public EventDetails() {}

    public EventDetails(int id, String email, String playDateCreatedOn) {
        Id = id;
        this.email = email;
        this.playDateCreatedOn = playDateCreatedOn;
    }
}