package com.playdate.playdate.services;

import com.playdate.playdate.models.UserDetailsCollection;
import com.playdate.playdate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NextSequenceNumberService {
    @Autowired private MongoOperations mongoOperations;
    @Autowired private UserRepository userRepository;

}
