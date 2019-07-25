package com.playdate;

import com.playdate.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class PlayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayDateApplication.class, args);
	}
}
