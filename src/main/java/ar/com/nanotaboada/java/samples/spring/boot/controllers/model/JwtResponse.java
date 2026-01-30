package ar.com.nanotaboada.java.samples.spring.boot.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtResponse {
    private String token;
}