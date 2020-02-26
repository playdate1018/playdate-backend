package com.playdate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
@Document
public class EventDetails {
//    private String id;
    @Id
    private String eventGuid;
    private String createdBy;
    private List<Participant> participants;
    private String when;
    private String where;
    private String description;
}