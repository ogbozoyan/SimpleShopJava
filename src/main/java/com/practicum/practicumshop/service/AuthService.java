package com.practicum.practicumshop.service;


import com.practicum.practicumshop.configuration.security.jwt.JwtResponse;
import com.practicum.practicumshop.web.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO);
}
