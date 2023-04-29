package com.practicum.practicumshop.configuration.security.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Data
@Component
@NoArgsConstructor
public class JwtResponse {
    private String tokenType = "Bearer";
    private String login;
    private String accessToken;
    public JwtResponse(String accessToken, String login) {
        this.accessToken = accessToken;
        this.login = login;
    }
}
