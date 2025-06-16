package com.example.ViaCep.configuracao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // libera todas as rotas
                        .allowedOrigins("*") // libera qualquer origem (frontend)
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // libera métodos
            }
        };
    }
}
