package ar.com.nanotaboada.java.samples.spring.boot.controllers;

import ar.com.nanotaboada.java.samples.spring.boot.controllers.model.LoginRequest;
import ar.com.nanotaboada.java.samples.spring.boot.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // Demo validation (replace with DB check in real apps)
        if (!"password".equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(request.getUsername());
       return ResponseEntity.status(HttpStatus.OK).body(String.format("{ \"token\" : \"%s\" }", token));
    }

}
