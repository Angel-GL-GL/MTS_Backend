package com.services.api.mts_reports;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")  // Permitir todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permitir los métodos necesarios
                .allowedHeaders("*")  // Permitir todos los encabezados
                .allowCredentials(false);  // No permitir credenciales para mayor flexibilidad
    }
}

