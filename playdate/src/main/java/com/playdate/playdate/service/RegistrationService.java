package com.playdate.playdate.service;

import com.playdate.playdate.model.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static com.playdate.playdate.util.RestEndpoints.BASE_URI;
import static com.playdate.playdate.util.RestEndpoints.USER_DETAILS;
import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.JACKSON_2;

@Service
public class RegistrationService {
    public Response registerUser(UserDetails userDetails){
        //TODO: do not allow reduntant registrations
        Response response;
        return  response = given().log().all()
                .contentType(ContentType.JSON)
                .body(userDetails, JACKSON_2)
                .when().post(BASE_URI + USER_DETAILS).thenReturn();
    }
}
