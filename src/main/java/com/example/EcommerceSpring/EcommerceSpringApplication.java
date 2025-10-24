package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class EcommerceSpringApplication {

	public static void main(String[] args) {
        // TODO: add retrofit
        // make api call
        // create 2 more apis
        Dotenv dotenv = Dotenv.configure().load();
        // loading the env
        dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(),entry.getValue()));
        // setting env variables
        SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
