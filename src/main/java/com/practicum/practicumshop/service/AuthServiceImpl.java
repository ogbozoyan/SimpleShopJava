package com.practicum.practicumshop.service;

import com.practicum.practicumshop.configuration.security.jwt.JwtProvider;
import com.practicum.practicumshop.configuration.security.jwt.JwtResponse;
import com.practicum.practicumshop.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO) {
        try {
            String trimmedLoginInLowerCase = loginDTO.getLogin().trim();
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    trimmedLoginInLowerCase,
                    loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info(authToken.getAuthorities().toString());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtProvider.generateToken(authentication);
            log.info(jwtToken);
            String login = jwtProvider.getLoginFromToken(jwtToken);
            return ResponseEntity.ok(new JwtResponse(jwtToken, login));
        } catch (InternalAuthenticationServiceException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}