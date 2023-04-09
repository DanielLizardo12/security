package com.dreamsw.security.config;

import com.dreamsw.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Daniel
 * @Date 08/04/2023
 */

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;

   @Bean
   public UserDetailsService userDetailsService() {
       return username -> repository.findByEmail(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found"));
   }

   @Bean
    public AuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
       authenticationProvider.setUserDetailsService(userDetailsService());
       authenticationProvider.setPasswordEncoder(passwordEncoder());

       return authenticationProvider;
   }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

}
