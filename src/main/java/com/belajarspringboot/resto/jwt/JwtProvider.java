package com.belajarspringboot.resto.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("auth-resto")
    private String jwtSecreet;

    @Value("900000") // 15 Menit
    private int expired;

    public String generateJwtToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() * expired))
                .signWith(SignatureAlgorithm.HS512, jwtSecreet)
                .compact();
    }

    public String gatUsernameToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecreet).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecreet).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException e) {
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException e) {
            System.out.println("Expired JWT Signature");
        }catch (UnsupportedJwtException e) {
            System.out.println("Unsuport JWT Signature");
        }catch (IllegalArgumentException e) {}
        return false;
    }
}
