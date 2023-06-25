package com.hbourgeot.todotech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
            auth.requestMatchers("/login").permitAll();
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/swagger-ui/**").permitAll();
            auth.requestMatchers("/static/**").permitAll();
            auth.requestMatchers("/api/**").permitAll();
            auth.anyRequest().authenticated();
        }).oauth2Login(oauth -> {
            oauth.defaultSuccessUrl("/dash");
            oauth.loginPage("/login");
        }).formLogin(login -> {
            login.disable();
        });
        return http.build();
    }

}