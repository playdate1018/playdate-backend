
package com.playdate.playdate.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "userDetailsCollection"
})
@Getter
@Setter
public class Links {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("userDetailsCollection")
    private UserDetailsCollection userDetailsCollection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
