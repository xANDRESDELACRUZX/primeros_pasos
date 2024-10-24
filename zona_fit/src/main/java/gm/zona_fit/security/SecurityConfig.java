package gm.zona_fit.security;

import gm.zona_fit.servicio.IJWTUtilityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
 public class SecurityConfig {
    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
             .csrf(csrf->
                   csrf.disable()
             )
             .authorizeHttpRequests(autoResquest -> //parte en la que hay que poner las rutas que quiero autenticar por los roles
                     autoResquest
                             .requestMatchers("/auth/**").permitAll()
                             .anyRequest().authenticated()
                     )
             .sessionManagement(sessionManager ->
                     sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             )
            .addFilterBefore(new JWTAutorizationFilter(jwtUtilityService),UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandling ->
                    exceptionHandling.authenticationEntryPoint((request, response, authException) -> {
                     response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Sin acceso");
                    }))
            .build();
    }
    @Bean
 public PasswordEncoder passwordEncoder(){
     return new BCryptPasswordEncoder();
    }
}
