package com.playdate.service;

import com.playdate.model.UserDetails;
import com.playdate.util.RestEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.JACKSON_2;

@CrossOrigin
@Service
public class RegistrationService {
    public Response registerUser(UserDetails userDetails){
        //TODO: do not allow reduntant registrations
        Response response;
        return  response = given().log().all()
                .contentType(ContentType.JSON)
                .body(userDetails, JACKSON_2)
                .when().post(RestEndpoints.BASE_URI + RestEndpoints.USER_DETAILS).thenReturn();
    }
}
