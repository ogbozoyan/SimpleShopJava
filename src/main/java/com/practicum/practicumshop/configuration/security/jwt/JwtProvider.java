package com.practicum.practicumshop.configuration.security.jwt;

import io.jsonwebtoken.*;
import lombok.Data;
import org.apache.commons.io.output.AppendableOutputStream;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.time.Instant;
import java.util.Date;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Component
@Data
public class JwtProvider {
    private static final String SECRET = "mega_secret";
    private static final int EXPIRATION_TIME = 864000000;

    public String generateToken(Authentication authentication) {
     CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
     return Jwts.builder().setSubject(user.getUsername())
             .setIssuedAt(Date.from(Instant.now()))
             .setExpiration(Date.from(Instant.now().plus(EXPIRATION_TIME, MINUTES)))
             .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt");
        } catch (Exception e) {
            System.out.println("invalid token");
        }
        return false;
    }
    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
