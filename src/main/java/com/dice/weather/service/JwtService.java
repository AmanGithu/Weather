package com.dice.weather.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JwtService {
    public String generateToken(UserDetails userDetails);

    public boolean validateToken(String authToken);

    public String getUsernameFromToken(String token);

    public List<SimpleGrantedAuthority> getRolesFromToken(String token);
}
