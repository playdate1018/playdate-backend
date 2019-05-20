
package com.playdate.playdate.model.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "username",
    "password",
    "nickName",
    "allergies",
    "age",
    "countryBorn",
    "ethnicity",
    "disabilities",
    "dob",
    "schoolName",
    "address",
    "parentsDetails",
    "previousPlayDates",
    "_links"
})
@Getter
@Setter
public class UserDetailsResponse {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("nickName")
    private Object nickName;
    @JsonProperty("allergies")
    private Object allergies;
    @JsonProperty("age")
    private Object age;
    @JsonProperty("countryBorn")
    private Object countryBorn;
    @JsonProperty("ethnicity")
    private Object ethnicity;
    @JsonProperty("disabilities")
    private Object disabilities;
    @JsonProperty("dob")
    private Object dob;
    @JsonProperty("schoolName")
    private Object schoolName;
    @JsonProperty("address")
    private Object address;
    @JsonProperty("parentsDetails")
    private Object parentsDetails;
    @JsonProperty("previousPlayDates")
    private Object previousPlayDates;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
