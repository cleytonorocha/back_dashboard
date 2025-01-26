package cleytonorocha.com.github.back_dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class BeanConfig {
    
    @Bean
    Faker createFaker(){
        return new Faker();
    }
}
