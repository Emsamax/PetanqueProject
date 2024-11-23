package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuration class for Spring Security.
 * This class defines the security settings for the application.
 */
@Configuration
public class WebSecurityConfig {

    /**
     * Configures the security filter chain for handling HTTP requests.
     * Specifies authorization rules, CSRF settings, CORS, and logout behavior.
     *
     * @param http the HttpSecurity object to configure
     * @return a configured SecurityFilterChain
     * @throws Exception if a configuration error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configures authorization rules: allows all requests without authentication.
                .authorizeHttpRequests(requests -> requests.anyRequest().permitAll())

                // Disables CSRF protection for all requests.
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**"))

                // Configures logout behavior: allows logout requests without authentication.
                .logout(LogoutConfigurer::permitAll)

                // Enables Cross-Origin Resource Sharing (CORS) using default settings.
                .cors(withDefaults());

        // Builds and returns the configured security filter chain.
        return http.build();
    }
}
