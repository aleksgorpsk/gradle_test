package ar.com.nanotaboada.java.samples.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeRequests(auth -> auth
                .anyRequest().authenticated());

        http.addFilter(tokenFilter());
        http.csrf().disable();

        return http.build();
    }
*/

}
