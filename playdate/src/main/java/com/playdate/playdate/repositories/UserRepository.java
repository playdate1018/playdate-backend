package com.playdate.playdate.repositories;


import com.playdate.playdate.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "userDetails", path = "userDetails")
public interface UserRepository extends MongoRepository<UserDetails,String> {

    UserDetails findByEmail(String email);
    UserDetails findByUsername(String username);

    UserDetails findByUsernameAndPassword(String username, String password);
    UserDetails findByEmailAndPassword(String email, String password);

}


