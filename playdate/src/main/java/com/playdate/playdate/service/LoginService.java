package com.playdate.playdate.service;

import com.playdate.playdate.model.UserDetails;
import com.playdate.playdate.model.request.LoginVerificationRequest;
import com.playdate.playdate.model.response.UserDetailsResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static com.playdate.playdate.util.RestEndpoints.*;
import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.JACKSON_2;

@Service
public class LoginService {
    public Boolean loginUser(LoginVerificationRequest loginVerificationRequest){
        //TODO: how do you handle when the email id in the url is not present in database
        UserDetailsResponse userDetailsResponse = given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URI + USER_DETAILS +"/"+loginVerificationRequest.email).as(UserDetailsResponse.class);
        return userDetailsResponse.getPassword().equals(loginVerificationRequest.getPassword());
    }

    public Boolean changePassword(LoginVerificationRequest loginVerificationRequest){
        UserDetailsResponse userDetailsResponse = given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URI + USER_DETAILS +"/"+loginVerificationRequest.email).as(UserDetailsResponse.class);
        //TODO: add login to verify if it is the correct person that is trying to change the password. eg: send security code to hi/her mobile

        //updating the password
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(loginVerificationRequest.getEmail());
        userDetails.setPassword(loginVerificationRequest.getPassword());

        userDetailsResponse.setPassword(loginVerificationRequest.getPassword());

        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .body(userDetailsResponse, JACKSON_2)
                .when().put(BASE_URI + USER_DETAILS).thenReturn();

        return response.getStatusCode() == 201;
    }
}
