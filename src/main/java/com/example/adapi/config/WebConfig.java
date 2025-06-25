package com.example.adapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // allow all endpoints
                .allowedOrigins("http://localhost:3000") // allow frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // allowed HTTP methods
                .allowedHeaders("*")
                .allowCredentials(true); // if you need cookies/session
    }
}
