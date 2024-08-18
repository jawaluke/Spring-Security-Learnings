package com.learn.spring_jwt_sec.domain;

import lombok.Data;

@Data
public class UserSignInBody {
    String clientName;
    String clientSecret;
}
