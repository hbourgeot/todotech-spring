package com.hbourgeot.todotech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/static/**").permitAll();
            auth.requestMatchers("/oauth_login").permitAll();
            auth.anyRequest().authenticated();
        })
                .oauth2Login(oauth -> {
                    oauth.defaultSuccessUrl("/dash");
                    oauth.loginPage("/oauth_login");
                })
                .formLogin(login -> {
                    login.disable();
                });
        return http.build();
    }
}