package com.playdate.playdate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
@Setter
@Document
public class EventDetails {

    //TODO: generate an automatic unique id
    @Id
    String id;

    @Indexed(unique = true)
    String email;

    //TODO: make these to Date data type
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    LocalDateTime playDateCreatedOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime playDateOn;

    HashMap<String, Boolean> responded;

    public EventDetails() {}

    public EventDetails(String id, String email, LocalDateTime playDateCreatedOn) {
        this.id = id;
        this.email = email;
        this.playDateCreatedOn = playDateCreatedOn;
    }
}