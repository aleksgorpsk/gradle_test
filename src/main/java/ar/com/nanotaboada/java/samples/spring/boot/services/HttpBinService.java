package ar.com.nanotaboada.java.samples.spring.boot.services;

import ar.com.nanotaboada.java.samples.spring.boot.security.JwtInterceptor;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


@Slf4j
@Service()
public class HttpBinService implements InitializingBean {

    @Value("${app.restUrl}")
    private String restUrl ;
    private final RestTemplate restTemplate;

    public HttpBinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void afterPropertiesSet() {
        log.info("!! afterPropertiesSet !");
     //   restTemplate.setInterceptors(Collections.singletonList(new JwtInterceptor(jwtToken)));

    };

    private String jwtSecret = "4261656C64756E67";

    SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private SecretKey createJWT(){
        String result = Jwts.builder()
                .subject(("testUser"))
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + 15000))
                .signWith(getSigningKey())
                .compact();

        byte[] keyBytes = Decoders.BASE64.decode(result);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    @PostConstruct
    public void init(){
        log.info("!! Init !");
    }
    public String getJson(){
        log.info("restUrl:"+restUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("",headers);

        return restTemplate.exchange(
                restUrl, HttpMethod.GET, entity, String.class).getBody();
    }

}
