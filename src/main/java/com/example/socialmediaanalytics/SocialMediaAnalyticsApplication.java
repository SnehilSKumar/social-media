package com.example.socialmediaanalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class SocialMediaAnalyticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaAnalyticsApplication.class, args);
    }

}
