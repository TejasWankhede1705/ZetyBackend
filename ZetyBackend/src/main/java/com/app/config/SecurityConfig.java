package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService;

    public SecurityConfig(OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
<<<<<<< HEAD
=======
        .csrf().disable()
>>>>>>> 412ad7e6bbe683ac256290346a0f4909d3e056c1
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/login**", "/oauth2/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()  // Allow public access
                    .requestMatchers("/auth/login/**").permitAll()  // Specific URL for OAuth2 login
                    .requestMatchers("/user/**").permitAll()  // Permit all URLs under /user/
<<<<<<< HEAD
                    .anyRequest().authenticated()  // Other paths require authentication
            )
=======
                    .anyRequest().authenticated() // Other paths require authentication
                    .and()
            )
            
>>>>>>> 412ad7e6bbe683ac256290346a0f4909d3e056c1
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .userInfoEndpoint(userInfoEndpoint ->
                        userInfoEndpoint
                            .userService(customOAuth2UserService)
                    )
<<<<<<< HEAD
                    .defaultSuccessUrl("/swagger-ui.html")  // Redirect to Swagger UI after successful login
=======
                    .successHandler((request, response, authentication) -> {
                        response.sendRedirect("/swagger-ui/index.html");  // Adjust path as needed
                    })
>>>>>>> 412ad7e6bbe683ac256290346a0f4909d3e056c1
            );

        return http.build();
    }
}
