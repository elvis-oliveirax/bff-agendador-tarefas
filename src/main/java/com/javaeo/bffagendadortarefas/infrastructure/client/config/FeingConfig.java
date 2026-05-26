package com.javaeo.bffagendadortarefas.infrastructure.client.config;

<<<<<<< HEAD
public class FeingConfig {
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeingConfig {

    @Bean
    public FeingError feingError(){
        return new FeingError();
    }
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a
}
