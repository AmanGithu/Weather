package com.dice.weather.service.impl;

import com.dice.weather.service.CustomUserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        if(username.equals("admin"))
        {
            roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User("admin","$2a$10$0Nv/Qa7m8DdjWpBS2XRZWeP8rWDB7OdScb2grQSRDS9I9fWWlBNG2",roles);
        }
        throw new UsernameNotFoundException("User not found with the name "+ username);
    }
}
