package com.learn.spring_jwt_sec.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_login")
public class UserLogin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int clientId;

    @Column(name = "client_name")
    String clientName;

    @Column(name = "client_secret")
    String clientSecret;
}
