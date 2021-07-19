package com.justclick.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JustclicktestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustclicktestApplication.class, args);
	}

}
