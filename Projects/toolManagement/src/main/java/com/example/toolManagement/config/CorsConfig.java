package com.example.toolManagement.config;
/**
 * @author Zulfa Attar
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*");
//                        .allowedOriginPatterns("*")
//                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
            }
        };
    }
}

//
//@Configuration
//@EnableWebSecurity
//public class cros {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//        httpSecurity.formLogin().disable();
//        httpSecurity.cors().and().csrf().disable();
//        return httpSecurity.build();
//    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods(CorsConfiguration.ALL)
//                        .allowedHeaders(CorsConfiguration.ALL)
//                        .allowedOriginPatterns(CorsConfiguration.ALL);
//            }
//        };
//    }