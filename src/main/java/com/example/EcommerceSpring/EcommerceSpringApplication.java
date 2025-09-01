package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        // loading the env
        dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(),entry.getValue()));
        // setting env variables
        SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
