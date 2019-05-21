package com.playdate.playdate;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.playdate.playdate.model.EventDetails;
import com.playdate.playdate.model.ParentsDetails;
import com.playdate.playdate.model.PreviousPlayDates;
import com.playdate.playdate.model.UserDetails;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MockUsers {
    @Autowired
    private MongoOperations mongoOperation=new MongoTemplate(new MongoClient("127.0.0.1"),"playdate");

    private static int numberOfUsers=100;

    private static int MIN = 0;
    private static int MAX = 3;

    private static int MIN_UID = 10;
    private static int MAX_UID = 500000;


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
        ParentsDetails parentsDetailsModel = new ParentsDetails();


//        private List<String> allergies;

//        private List<String> disabilities;

        GenerateRandomDataHelpers generateRandomDataHelpers = new GenerateRandomDataHelpers();
        generateTestData();
        for(int i = 0; i < numberOfUsers; i++) {
            String ID =UUID.randomUUID().toString();
            String EMAIL = "email"+getUid()+"@gmail.com";
            UserDetails userDetails = new UserDetails();
            userDetails.setId(ID);
            userDetails.setEmail(EMAIL);
            userDetails.setUsername(username.get(getRandomNumber()));
            userDetails.setPassword(password.get(getRandomNumber()));
            userDetails.setNickName(nickName.get(getRandomNumber()));
            userDetails.setAge(age.get(getRandomNumber()));
            userDetails.setCountryBorn(countryBorn.get(getRandomNumber()));
            userDetails.setCountryBorn(ethnicity.get(getRandomNumber()));
            userDetails.setDob(dob.get(getRandomNumber()));
            userDetails.setSchoolName(schoolName.get(getRandomNumber()));
            userDetails.setSchoolName(address.get(getRandomNumber()));

            ParentsDetails parentsDetailsModel1 = new ParentsDetails();
            parentsDetailsModel1.setFatherName(fatherName.get(getRandomNumber()));
            parentsDetailsModel1.setMotherName(motherName.get(getRandomNumber()));
            parentsDetailsModel1.setFatherOccupation(fatherOccupation.get(getRandomNumber()));
            parentsDetailsModel1.setMotherOccupation(motherOccupation.get(getRandomNumber()));
            parentsDetailsModel1.setFatherContactNumber(fatherContactNumber.get(getRandomNumber()));
            parentsDetailsModel1.setMotherContactNumber(motherContactNumber.get(getRandomNumber()));
            parentsDetailsModel1.setFatherAge(fatherAge.get(getRandomNumber()));
            parentsDetailsModel1.setMotherAge(motherAge.get(getRandomNumber()));
            userDetails.setParentsDetails(parentsDetailsModel1);

            List<PreviousPlayDates> previousPlayDatesList = new ArrayList<>();
            PreviousPlayDates previousPlayDates1 = new PreviousPlayDates();
            previousPlayDates1.setWhen(when.get(getRandomNumber()));
            previousPlayDates1.setWhere(when.get(getRandomNumber()));
            previousPlayDates1.setDuration(when.get(getRandomNumber()));

            PreviousPlayDates previousPlayDates2 = new PreviousPlayDates();
            previousPlayDates2.setWhen(when.get(getRandomNumber()));
            previousPlayDates2.setWhere(when.get(getRandomNumber()));
            previousPlayDates2.setDuration(when.get(getRandomNumber()));

            previousPlayDatesList.add(previousPlayDates1);
            previousPlayDatesList.add(previousPlayDates2);
            userDetails.setPreviousPlayDates(previousPlayDatesList);

            Gson gson = new Gson();
            String request = gson.toJson(userDetails);

            EventDetails eventDetails = new EventDetails(ID,EMAIL, LocalDateTime.now());
            String request1 = gson.toJson(eventDetails);
            mongoOperation.save(userDetails);
            mongoOperation.save(eventDetails);
            System.out.println("wait");
//            Response response = given().log().all()
//                    .contentType(ContentType.JSON)
//                    .body(userDetails, JACKSON_2)
//                    .when().post("http://localhost:8080/userDetails").thenReturn();
//            System.out.println("STATUS CODE: "+response.getStatusCode());
//            //Assert.assertTrue(response.getStatusCode() == 201);
//            ApplicationContext ctx =
//                    new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//            MongoOperations mongoOperation =
//                    (MongoOperations) ctx.getBean("mongoTemplate");

        }
    }


    public static int getRandomNumber(){
        return new Random().nextInt((MAX - MIN) + 1) + MIN;
    }

    public static int getUid(){
        return new Random().nextInt((MAX_UID - MIN_UID) + 1) + MIN_UID;
    }

}
