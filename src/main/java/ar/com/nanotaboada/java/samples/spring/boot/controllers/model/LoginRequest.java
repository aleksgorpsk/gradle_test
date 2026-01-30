package ar.com.nanotaboada.java.samples.spring.boot.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public  class LoginRequest {
    private String username;
    private String password;
}