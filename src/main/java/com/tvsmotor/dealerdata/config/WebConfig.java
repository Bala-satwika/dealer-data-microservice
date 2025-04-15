package com.tvsmotor.dealerdata.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
@Configuration
public class WebConfig implements WebFluxConfigurer {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**") // Allow all endpoints
.allowedOrigins("http://localhost:3000") // Replace with your frontend URL
.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these methods
.allowedHeaders("*") // Allow all headers
.allowCredentials(true); // Allow credentials if needed
}
}