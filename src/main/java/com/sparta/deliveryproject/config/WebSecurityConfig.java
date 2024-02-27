package com.sparta.deliveryproject.config;



import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)


@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

}
