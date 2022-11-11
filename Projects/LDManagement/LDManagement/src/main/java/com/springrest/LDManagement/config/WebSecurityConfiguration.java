//package com.springrest.LDManagement.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private JwtFilter jwtFilter;
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return provider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().
//                authorizeRequests().
//                antMatchers("/authenticate").
//                permitAll()
//                .antMatchers("/admin/**").
//                hasAnyAuthority("ADMIN")
//                .antMatchers("/trainer/**").
//                hasAnyAuthority("TRAINER")
//                .antMatchers("/student/**").
//                hasAnyAuthority("STUDENT")
//                .anyRequest().
//                authenticated().
//                and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//}
