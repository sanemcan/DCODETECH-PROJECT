package com.dcodetech.ATMMACHINE;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200") // Allow requests from this origin //ikdun request yenar backend la
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods //konta metthod use hotil te lihla support konta kartil
            .allowedHeaders("*") // Allowed headers (you can customize this)// he sagar udya sangel
            .allowCredentials(true); // Allow cookies if your application uses them
    }
}