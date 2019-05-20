package com.playdate.playdate.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@Document
public class UserDetails {

    @Id
    @Indexed
    @Email
    private String email;

    private String username;
    private String password;
    private String nickName;
    private List<String> allergies;
    private String age;
    private String countryBorn;
    private String ethnicity;
    private List<String> disabilities;
    private String dob;
    private String schoolName;
    private String address;
    private ParentsDetails parentsDetails;
    private List<PreviousPlayDates> previousPlayDates;


    public UserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDetails() {
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", allergies=" + allergies +
                ", age='" + age + '\'' +
                ", countryBorn='" + countryBorn + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", disabilities=" + disabilities +
                ", dob='" + dob + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                ", parentsDetails=" + parentsDetails +
                ", previousPlayDates=" + previousPlayDates +
                '}';
    }


}
