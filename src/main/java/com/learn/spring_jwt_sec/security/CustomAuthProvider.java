package com.learn.spring_jwt_sec.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Authentication Provider: {}",authentication.toString());
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // Password Equals
        if(userDetails!=null && passwordEncoder.matches(password,userDetails.getPassword())) {
            log.info("User has been identified successfully");
            // you have to add authority or else you get 403
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            if(username.equals("ADMIN")) {
                grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
            }
            else {
                grantedAuths.add(new SimpleGrantedAuthority("USER"));
            }
            log.info("authority: {}",grantedAuths);
            return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuths);
        }
        log.info("User has failed to identified");
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
