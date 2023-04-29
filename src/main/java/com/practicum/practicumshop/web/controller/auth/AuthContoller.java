package com.practicum.practicumshop.web.controller.auth;

import com.practicum.practicumshop.configuration.security.jwt.JwtResponse;
import com.practicum.practicumshop.model.UserEntity;
import com.practicum.practicumshop.service.AuthService;
import com.practicum.practicumshop.service.UserService;
import com.practicum.practicumshop.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthContoller {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public UserEntity signUp(@RequestBody UserEntity signUpDTO) {
        return userService.signUp(signUpDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDTO loginDTO) {
        return authService.signIn(loginDTO);
    }
}
