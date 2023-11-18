package com.huseyinyetisir.BookstoreBE.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests(configurer -> configurer.antMatchers("/api/books/secure/**")
                .authenticated())
                .oauth2ResourceServer()
                .jwt();

        http.cors();

        // http.setSharedObject(ContentNegotiationStrategy, //TO:DO
        // configurer.HeaderContentNegotiationStrategy())

        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
}
