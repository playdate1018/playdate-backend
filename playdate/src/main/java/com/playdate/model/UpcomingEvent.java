package com.playdate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@Builder
public class UpcomingEvent {
    public String eventGuid;
    public String when;
    public String where;
    public String description;
    public String status;
}
