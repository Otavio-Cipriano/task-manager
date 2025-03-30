package com.example.task_manager.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para H2 Console
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**", // API Docs do Swagger
                                "/swagger-ui/**",   // Interface gráfica do Swagger
                                "/swagger-ui.html", // Página principal do Swagger
                                "/h2-console/**",   // Console do H2
                                "/tasks/**",
                                "/auth/**"
                        ).permitAll() // Permitir acesso a essas rotas sem autenticação
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // Permitir o uso do H2 Console
                .formLogin(login -> login.disable()) // Remover login padrão do Spring Security (caso não esteja usando autenticação)
                .httpBasic(httpBasic -> httpBasic.disable()); // Desativar autenticação básica (se necessário)

        return http.build();

    }
}
