package com.giventech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// The annotation @EnableTransactionManagement  is turned on by default
// When spring-data dependency is added to pom.
// @EnableTransactionManagement


@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
