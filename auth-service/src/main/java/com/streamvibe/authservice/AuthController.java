package com.streamvibe.authservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/token")
    public String getToken(@RequestParam String username) {
        // In a real app, we'd verify username/password against user-service.
        // For this microservice architecture bonus, we fulfill stateless generation.
        return jwtService.generateToken(username);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }
}
