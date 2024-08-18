package com.learn.spring_jwt_sec.controller;

import com.learn.spring_jwt_sec.domain.UserLogin;
import com.learn.spring_jwt_sec.domain.UserSignInBody;
import com.learn.spring_jwt_sec.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private PasswordEncoder passwordEncoder;

    private UserLoginService userLoginService;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, UserLoginService userLoginService) {
        this.passwordEncoder = passwordEncoder;
        this.userLoginService = userLoginService;
    }

    @PostMapping("/sign")
    public String signIn(@RequestBody UserSignInBody userSignInBody) {
        if(!userLoginService.isUserExists(userSignInBody.getClientName())) {
            UserLogin userLogin = UserLogin.builder()
                    .clientName(userSignInBody.getClientName())
                    .clientSecret(passwordEncoder.encode(userSignInBody.getClientSecret()))
                    .build();
            if(userLoginService.save(userLogin)) {
                return "User saved successfully";
            };
            return "user not saved";
        }
        return "user already exists";
    }
}
