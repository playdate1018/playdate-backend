package com.playdate.playdate.repositories;


import com.playdate.playdate.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "userDetails", path = "userDetails")
public interface UserRepository extends MongoRepository<UserDetails,String> {
    List<UserDetails> email(@Param("email") String email);
    List<UserDetails> findByUsername(@Param("username") String username);
    List<UserDetails> findByNickName(@Param("nickname") String nickname);
    List<UserDetails> findByAge(@Param("age") String age);
    List<UserDetails> findByCountryBorn(@Param("countryborn") String countryborn);
    List<UserDetails> findByEthnicity(@Param("ethnicity") String ethnicity);
    List<UserDetails> findBySchoolName(@Param("schoolname") String schoolname);
    List<UserDetails> findByUsernameStartingWith(@Param("startingWith") String startingWith);


    UserDetails findByUsernameAndPassword(String username, String password);

}


