package edu.depaul.cdm.se452.herokudemoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HerokuDemoAppApplication {

    @Value( "${app.greeting}" )
    private String greeting;
		
	public static void main(String[] args) {
		SpringApplication.run(HerokuDemoAppApplication.class, args);
	}

	@Bean
	public void sayToConsole() {
		System.out.println("Hello: " + greeting);
	}

}
