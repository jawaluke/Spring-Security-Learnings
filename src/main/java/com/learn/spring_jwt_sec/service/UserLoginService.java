package com.learn.spring_jwt_sec.service;

import com.learn.spring_jwt_sec.domain.UserLogin;
import com.learn.spring_jwt_sec.repository.UserLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLoginService implements UserDetailsService {

    UserLoginRepository userLoginRepository;

    @Autowired
    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = this.userLoginRepository.findByClientName(username);
        log.info("user: {}",user);
        return User.builder()
                .username(user.getClientName())
                .password(user.getClientSecret())
                .build();
    }


    public boolean isUserExists(String clientName) {
        log.info("repo: {}",userLoginRepository.findByClientName(clientName) != null);
        return userLoginRepository.findByClientName(clientName) != null;
    }

    public boolean save(UserLogin userLogin) {
        return userLoginRepository.save(userLogin) != null;
    }
}
