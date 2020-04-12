package com.playdate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlaydatesRequested {
//    private String when;
//    private String where;
//    private String description;
    private String eventId;
    private String status;
    //email will be saved in requestedBy
    private String requestedBy;
    private String requestedTo;
    private String base64Image;
}
