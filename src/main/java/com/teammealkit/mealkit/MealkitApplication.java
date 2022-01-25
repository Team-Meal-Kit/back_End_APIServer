package com.teammealkit.mealkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MealkitApplication {
	public static void main(String[] args) {
		SpringApplication.run(MealkitApplication.class, args);
	}
}
