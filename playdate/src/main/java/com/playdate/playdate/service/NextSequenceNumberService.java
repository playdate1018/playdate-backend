package com.playdate.playdate.service;

import com.playdate.playdate.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NextSequenceNumberService {
    private final MongoOperations mongoOperations;
    private final UserRepository userRepository;
}
