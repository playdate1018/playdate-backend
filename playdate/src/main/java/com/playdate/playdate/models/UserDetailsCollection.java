package com.playdate.playdate.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class UserDetailsCollection {
    @Id
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
    private ParentsDetailsModel parentsDetails;
    private List<PreviousPlayDatesModel> previousPlayDates;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountryBorn() {
        return countryBorn;
    }

    public void setCountryBorn(String countryBorn) {
        this.countryBorn = countryBorn;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParentsDetailsModel getParentsDetails() {
        return parentsDetails;
    }

    public void setParentsDetails(ParentsDetailsModel parentsDetails) {
        this.parentsDetails = parentsDetails;
    }

    public List<PreviousPlayDatesModel> getPreviousPlayDates() {
        return previousPlayDates;
    }

    public void setPreviousPlayDates(List<PreviousPlayDatesModel> previousPlayDates) {
        this.previousPlayDates = previousPlayDates;
    }
}
