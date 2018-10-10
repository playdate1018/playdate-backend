package com.playdate.playdate;

import com.google.gson.Gson;
import com.playdate.playdate.models.ParentsDetailsModel;
import com.playdate.playdate.models.PreviousPlayDatesModel;
import com.playdate.playdate.models.UserDetailsCollection;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.JACKSON_2;

public class MockUsers {

    private static int numberOfUsers=100;

    private static int MIN = 0;
    private static int MAX = 3;

    private static int MIN_UID = 10;
    private static int MAX_UID = 5000;


    static List<String> fatherName = new ArrayList<>();
    static List<String> motherName = new ArrayList<>();
    static List<String> fatherOccupation = new ArrayList<>();
    static List<String> motherOccupation = new ArrayList<>();
    static List<String> fatherContactNumber = new ArrayList<>();
    static List<String> motherContactNumber = new ArrayList<>();
    static List<String> fatherAge = new ArrayList<>();
    static List<String> motherAge = new ArrayList<>();
    static List<String> when = new ArrayList<>();
    static List<String> where = new ArrayList<>();
    static List<String> duration = new ArrayList<>();
    static List<String> username = new ArrayList<>();
    static List<String> password = new ArrayList<>();
    static List<String> nickName = new ArrayList<>();
    static List<String> age = new ArrayList<>();
    static List<String> countryBorn = new ArrayList<>();
    static List<String> ethnicity = new ArrayList<>();
    static List<String> dob = new ArrayList<>();
    static List<String> schoolName = new ArrayList<>();
    static List<String> address = new ArrayList<>();

    static void generateTestData(){
        fatherName.add("David Wroe");
        fatherName.add("Anthony Barber");
        fatherName.add("Geoff Grinney");
        fatherName.add("Sam Ryanstead");
        fatherName.add("David Larson");

        motherName.add("Alison");
        motherName.add("Mary Larson");
        motherName.add("Katie Howe");
        motherName.add("Aashritha Rao");
        motherName.add("Geetika Parakala");

        fatherOccupation.add("Software Developer");
        fatherOccupation.add("Pilot");
        fatherOccupation.add("House Construction");
        fatherOccupation.add("Mechanic");
        fatherOccupation.add("Chef");

        motherOccupation.add("HouseWife");
        motherOccupation.add("Software Developer");
        motherOccupation.add("HR");
        motherOccupation.add("Quality Analyst Engineer");
        motherOccupation.add("Server");

        fatherContactNumber.add("9182618271");
        fatherContactNumber.add("3201827191");
        fatherContactNumber.add("2472162528");
        fatherContactNumber.add("5272632628");

        motherContactNumber.add("3425342916");
        motherContactNumber.add("2927392718");
        motherContactNumber.add("9817271527");
        motherContactNumber.add("3293829273");


        fatherAge.add("43");
        fatherAge.add("49");
        fatherAge.add("31");
        fatherAge.add("38");

        motherAge.add("29");
        motherAge.add("33");
        motherAge.add("31");
        motherAge.add("36");

        when.add("Nov'18");
        when.add("Oct'18");
        when.add("Jan'18");
        when.add("March'18");

        where.add("Richfield playground");
        where.add("Wayzata playground");
        where.add("Plymouth playground");
        where.add("Edina playground");

        duration.add("1 hour");
        duration.add("1 1/2 hour");
        duration.add("2 hour");
        duration.add("45 minutes");

        username.add("Johnson Larson");
        username.add("Amy Barber");
        username.add("Justin Ryanstead");
        username.add("Mary Grinney");

        password.add("Pa$$word1!");
        password.add("Pa55word1!");
        password.add("Pa44word1!");
        password.add("Pa33word1!");

        nickName.add("pinky");
        nickName.add("john");
        nickName.add("ali");
        nickName.add("lucky");

        age.add("6");
        age.add("7");
        age.add("6");
        age.add("9");

        countryBorn.add("U.S.A");
        countryBorn.add("U.S.A");
        countryBorn.add("U.S.A");
        countryBorn.add("U.S.A");

        ethnicity.add("Asian");
        ethnicity.add("Asian");
        ethnicity.add("NothAmerican");
        ethnicity.add("NothAmerican");

        dob.add("02-01-2012");
        dob.add("05-11-2010");
        dob.add("09-23-2011");
        dob.add("03-09-2009");

        schoolName.add("Wayzata School");
        schoolName.add("Richfield School");
        schoolName.add("Maple Grove School");
        schoolName.add("Plymouth School");

        address.add("912 gold lane, #012, Wayzata, 55263 MN.");
        address.add("7611 Knox Ave S, #305, Richfield, 55423 MN.");
        address.add("0129 silverlane, #912, Maple Grove, 52532 MN.");
        address.add("310 lane west, #123, Plymouth, 52635 MN.");
    }

    @Test
    public void insertUsers(){
        ParentsDetailsModel parentsDetailsModel = new ParentsDetailsModel();


//        private List<String> allergies;

//        private List<String> disabilities;

        GenerateRandomDataHelpers generateRandomDataHelpers = new GenerateRandomDataHelpers();
        generateTestData();
        for(int i = 0; i < numberOfUsers; i++) {
            UserDetailsCollection userDetailsCollection = new UserDetailsCollection();
            userDetailsCollection.setEmail("email"+getUid()+"@gmail.com");
            userDetailsCollection.setUsername(username.get(getRandomNumber()));
            userDetailsCollection.setPassword(password.get(getRandomNumber()));
            userDetailsCollection.setNickName(nickName.get(getRandomNumber()));
            userDetailsCollection.setAge(age.get(getRandomNumber()));
            userDetailsCollection.setCountryBorn(countryBorn.get(getRandomNumber()));
            userDetailsCollection.setCountryBorn(ethnicity.get(getRandomNumber()));
            userDetailsCollection.setDob(dob.get(getRandomNumber()));
            userDetailsCollection.setSchoolName(schoolName.get(getRandomNumber()));
            userDetailsCollection.setSchoolName(address.get(getRandomNumber()));

            ParentsDetailsModel parentsDetailsModel1 = new ParentsDetailsModel();
            parentsDetailsModel1.setFatherName(fatherName.get(getRandomNumber()));
            parentsDetailsModel1.setMotherName(motherName.get(getRandomNumber()));
            parentsDetailsModel1.setFatherOccupation(fatherOccupation.get(getRandomNumber()));
            parentsDetailsModel1.setMotherOccupation(motherOccupation.get(getRandomNumber()));
            parentsDetailsModel1.setFatherContactNumber(fatherContactNumber.get(getRandomNumber()));
            parentsDetailsModel1.setMotherContactNumber(motherContactNumber.get(getRandomNumber()));
            parentsDetailsModel1.setFatherAge(fatherAge.get(getRandomNumber()));
            parentsDetailsModel1.setMotherAge(motherAge.get(getRandomNumber()));
            userDetailsCollection.setParentsDetails(parentsDetailsModel1);

            List<PreviousPlayDatesModel> previousPlayDatesModelList = new ArrayList<>();
            PreviousPlayDatesModel previousPlayDatesModel1 = new PreviousPlayDatesModel();
            previousPlayDatesModel1.setWhen(when.get(getRandomNumber()));
            previousPlayDatesModel1.setWhere(when.get(getRandomNumber()));
            previousPlayDatesModel1.setDuration(when.get(getRandomNumber()));

            PreviousPlayDatesModel previousPlayDatesModel2 = new PreviousPlayDatesModel();
            previousPlayDatesModel2.setWhen(when.get(getRandomNumber()));
            previousPlayDatesModel2.setWhere(when.get(getRandomNumber()));
            previousPlayDatesModel2.setDuration(when.get(getRandomNumber()));

            previousPlayDatesModelList.add(previousPlayDatesModel1);
            previousPlayDatesModelList.add(previousPlayDatesModel2);
            userDetailsCollection.setPreviousPlayDates(previousPlayDatesModelList);

            Gson gson = new Gson();
            String request = gson.toJson(userDetailsCollection);

            Response response = given().log().all()
                    .contentType(ContentType.JSON)
                    .body(userDetailsCollection, JACKSON_2)
                    .when().post("http://localhost:8080/userDetails").thenReturn();
            System.out.println("STATUS CODE: "+response.getStatusCode());
            Assert.assertTrue(response.getStatusCode() == 201);
        }
    }


    public static int getRandomNumber(){
        return new Random().nextInt((MAX - MIN) + 1) + MIN;
    }

    public static int getUid(){
        return new Random().nextInt((MAX_UID - MIN_UID) + 1) + MIN_UID;
    }

}
