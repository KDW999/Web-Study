package com.kdw.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kdw.board.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .cors().and()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("/api/board/my-list").authenticated()
            .antMatchers("/auth/**", "/file/**").permitAll() // 인가해줄 url 지정
            .antMatchers(HttpMethod.GET, "/api/board/**").permitAll()
            .anyRequest().authenticated().and()
            .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
    // 접근 인가 url 설정
    // .antMatchers(HttpMethod.GET, "/api/board/**").permitAll() 

    // 해당 url에 접근 인가가 설정 되어있지 않아도 토큰을 가지고 있으면 접근 가능
    // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZUBuYXZlci5jb20iLCJpYXQiOjE2Nzg5NDU3MDEsImV4cCI6MTY3ODk0OTMwMX0.hdpLB0zAyQKy6Siy_Cj0ByvfR3L_kbylGTqj9tgUJv0
    
    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
        .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/swagger/**", "/v2/api-docs", "/webjars/**"); 
    }
}
