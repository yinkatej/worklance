package com.web3.demo.configuration;

//import com.web3.demo.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final UserDetailServiceImpl userDetailService;
//
//    public SecurityConfig(UserDetailServiceImpl userDetailService) {
//        this.userDetailService = userDetailService;
//    }

//    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
//        throws Exception {
//        return configuration.getAuthenticationManager();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http.csrf(csrf->csrf.disable())
              .sessionManagement(mgt->mgt.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authorizeHttpRequests(authRequest-> authRequest.anyRequest()
                      .permitAll());
      return http.build();
    }
}
