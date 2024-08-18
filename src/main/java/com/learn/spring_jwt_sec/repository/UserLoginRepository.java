package com.learn.spring_jwt_sec.repository;

import com.learn.spring_jwt_sec.domain.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    UserLogin findByClientName(String username);
}