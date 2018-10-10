package com.playdate.playdate.repositories;


import com.playdate.playdate.models.UserDetailsCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "userDetails", path = "userDetails")
public interface UserRepository extends MongoRepository<UserDetailsCollection,String> {
    List<UserDetailsCollection> email(@Param("email") String email);
    List<UserDetailsCollection> findByUsername(@Param("username") String username);
    List<UserDetailsCollection> findByNickName(@Param("nickname") String nickname);
    List<UserDetailsCollection> findByAge(@Param("age") String age);
    List<UserDetailsCollection> findByCountryBorn(@Param("countryborn") String countryborn);
    List<UserDetailsCollection> findByEthnicity(@Param("ethnicity") String ethnicity);
    List<UserDetailsCollection> findBySchoolName(@Param("schoolname") String schoolname);

    List<UserDetailsCollection> findByUsernameStartingWith(@Param("startingWith") String startingWith);

}


