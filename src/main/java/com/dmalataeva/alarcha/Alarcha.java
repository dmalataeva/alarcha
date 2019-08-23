package com.dmalataeva.alarcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.dmalataeva.alarcha")
@EntityScan("com.dmalataeva.alarcha.entities")
@EnableJpaRepositories(basePackages= "com.dmalataeva.alarcha.repositories")
public class Alarcha {
    public static void main(String[] args) {

        // start Spring Application
        // this application will start an HTTP server on http://localhost:8080
        // and bind com.dmalataeva.alarcha.controllers as API endpoints
        SpringApplication.run(Alarcha.class, args);
        System.out.println("started SpringBootApplication");
    }
}
