package com.example.demo.Configs;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Services.UserServices;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigs {
    @Autowired
    UserServices service;  
    
    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration)throws Exception {

            return authenticationConfiguration.getAuthenticationManager();
        }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        var builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service).passwordEncoder(bCryptPasswordEncoder());

        var authenticationManager = builder.build();

        httpSecurity.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/users").permitAll()
            .anyRequest().authenticated()).authenticationManager(authenticationManager).httpBasic(withDefaults());

        return httpSecurity.build();

    }
    
}
