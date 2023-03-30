package com.kdw.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
    
    //# CORS( CROSS - Origin Resource Sharing) 정책
    //? 다른 출처(localhost3000, 4040을 같이 쓰는 경우 등)의 자원을 공유할 수 있도록 설정하는 권한 정책

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
       corsRegistry.addMapping("/**")    // 백엔드 url 허용?
                   .allowedOrigins("*")   // 접근 권한 모두 허용
                   .allowedMethods("*");   // 모든 메서드 허용
                   
    }  
}
