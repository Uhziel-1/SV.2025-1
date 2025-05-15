package com.example.msauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Sigue siendo una clase de configuración
public class SecurityConfig {

    // Define un Bean de tipo SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilita CSRF
                .csrf(csrf -> csrf.disable())
                // Configura las reglas de autorización de solicitudes
                .authorizeHttpRequests(authz -> authz
                        // Permite cualquier solicitud (esto es lo que hacía anyRequest().permitAll())
                        .anyRequest().permitAll()
                );

        // Construye y devuelve la cadena de filtros de seguridad
        return http.build();
    }

    // Si solo necesitas configurar HttpSecurity como en tu ejemplo original,
    // no necesitas definir explícitamente un AuthenticationManager bean a menos
    // que tengas una configuración de autenticación más compleja que la por defecto.
    // Spring Boot y Spring Security 6.x manejan la configuración por defecto.
}
