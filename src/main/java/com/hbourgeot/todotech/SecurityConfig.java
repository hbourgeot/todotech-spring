package com.hbourgeot.todotech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// class for spring security 6 config
// this is awesome
@Configuration
public class SecurityConfig {

    // define a bean
    @Bean

    //define a method of security
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> {csrf.disable();}).headers(header -> header.frameOptions(opt -> opt.disable())).authorizeHttpRequests(auth -> {
            // not protected paths
            auth.requestMatchers("/login").permitAll();
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/product/**").permitAll();
            auth.requestMatchers("/swagger-ui/**").permitAll();
            auth.requestMatchers("/static/**").permitAll();
            auth.requestMatchers("/api/**").permitAll();
            auth.requestMatchers("/h2-console/**").permitAll();

            // any other request must be authenticated
            auth.anyRequest().authenticated();
        }).oauth2Login(oauth -> {

            // default success url for oauth after login
            oauth.defaultSuccessUrl("/dash/products");

            // login page for oauth
            oauth.loginPage("/login");
        }).formLogin(login -> {
            login.disable();
            // we disable the classic form login
        });

        // return and build
        return http.build();
    }

}