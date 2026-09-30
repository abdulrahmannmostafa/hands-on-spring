package com.qeema.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

        /*
         * @Bean
         * public InMemoryUserDetailsManager userDetailsService() {
         * UserDetails user = User.builder()
         * .username("bedo")
         * .password("{noop}bedo")
         * .roles("Employee", "Manager", "Admin")
         * .build();
         * 
         * UserDetails admin = User.builder()
         * .username("admin")
         * .password("{noop}admin")
         * .roles("Admin")
         * .build();
         * 
         * UserDetails manager = User.builder()
         * .username("manager")
         * .password("{noop}manager")
         * .roles("Manager")
         * .build();
         * 
         * return new InMemoryUserDetailsManager(user, admin, manager);
         * }
         * 
         */

        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource) {
                return new JdbcUserDetailsManager(dataSource);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

                );

                http.httpBasic(Customizer.withDefaults());
                http.csrf(csrf -> csrf.disable());
                return http.build();
        }
}
