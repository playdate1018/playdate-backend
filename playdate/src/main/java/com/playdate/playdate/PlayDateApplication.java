package com.playdate.playdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class PlayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayDateApplication.class, args);
	}
}
