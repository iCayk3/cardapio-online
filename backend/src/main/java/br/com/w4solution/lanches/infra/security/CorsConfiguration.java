package br.com.w4solution.lanches.infra.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // permite todos os endpoints da API
                .allowedOrigins("*") // permite requisições de todos os hosts
                .allowedMethods("*") // métodos HTTP permitidos
                .allowedHeaders("*") // permite todos os cabeçalhos
                .allowCredentials(false); // permite enviar cookies, se necessário
    }
}
