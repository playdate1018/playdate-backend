package com.playdate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    String street;
    String city;
    String state;
    String zipcode;
    String country;
}