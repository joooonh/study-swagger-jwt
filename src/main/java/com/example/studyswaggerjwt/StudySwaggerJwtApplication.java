package com.example.studyswaggerjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudySwaggerJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySwaggerJwtApplication.class, args);
    }

}
