package com.playdate.playdate;

import com.playdate.playdate.configuration.SpringMongoConfig;
import com.playdate.playdate.model.EventDetails;
import com.playdate.playdate.model.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class PlayDateApplication {

	public static MongoOperations mongoOperation;
	public static void main(String[] args) {

		SpringApplication.run(PlayDateApplication.class, args);
		// For Annotation
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation =
				(MongoOperations) ctx.getBean("mongoTemplate");

		EventDetails eventDetails = new EventDetails(1,"rul@gmail.com","today");
		mongoOperation.save(eventDetails);

	}

}
