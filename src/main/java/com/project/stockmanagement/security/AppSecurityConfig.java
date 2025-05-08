package com.project.stockmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@EnableWebSecurity
@Configuration
public class AppSecurityConfig {
    @Bean
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    @Bean
    public AuthenticationFailureHandler getAuthenticationFailureHandler () {
        return new CustomAuthenticationFailureHandler();
    }
    @Bean
    public UserDetailsService getUserDetailsService () {
        return new CustomDaoBasedUserDetailsService();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure AuthenticationProvider
    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(getUserDetailsService());
        // define the hash algorithm of the password
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/adminuser/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .failureHandler(getAuthenticationFailureHandler())
                        .successHandler(getAuthenticationSuccessHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied")
                );

        return http.build();
    }
}
