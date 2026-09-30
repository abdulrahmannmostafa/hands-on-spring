package com.qeema.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
                UserDetails user = User.builder()
                                .username("bedo")
                                .password("{noop}bedo")
                                .roles("Employee", "Manager", "Admin")
                                .build();

                UserDetails admin = User.builder()
                                .username("admin")
                                .password("{noop}admin")
                                .roles("Admin")
                                .build();

                UserDetails manager = User.builder()
                                .username("manager")
                                .password("{noop}manager")
                                .roles("Manager")
                                .build();

                return new InMemoryUserDetailsManager(user, admin, manager);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("Employee", "Admin")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("Employee")
                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("Manager")
                                .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("Manager")
                                .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("Manager")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("Admin")

                );

                http.httpBasic(Customizer.withDefaults());
                http.csrf(csrf -> csrf.disable());
                return http.build();
        }
}
