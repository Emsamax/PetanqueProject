package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration class for setting up Cross-Origin Resource Sharing (CORS) in the application.
 * CORS allows controlled access to resources from different origins.
 */
@Configuration
public class AppCorsConfig {

    /**
     * Configures CORS settings for the application.
     * Specifies the allowed origins, HTTP methods, and headers for cross-origin requests.
     *
     * @return a configured CorsConfigurationSource object
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Specifies the allowed origins. Here, it allows Angular frontend running on localhost:4200.
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));

        // Specifies the allowed HTTP methods for cross-origin requests.
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

        // Specifies the allowed headers in cross-origin requests.
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Auth-Token"));

        // Registers the CORS configuration for all paths in the application.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
