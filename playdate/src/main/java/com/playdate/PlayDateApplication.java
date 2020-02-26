package com.playdate;

import com.playdate.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class PlayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayDateApplication.class, args);
	}
}
