package com.example.settlement.domain.user.dto;

import jakarta.persistence.*;

import java.security.Timestamp;

@Table(name = "USER")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME", nullable = false, length = 100)
    private String userName;

    @Column(name = "USER_PASSWORD", nullable = false, length = 255)
    private String userPassword;

    @Column(name = "USER_EMAIL", nullable = false, length = 255)
    private String userEmail;

    @Column(name = "USER_LEVEL", nullable = false)
    private String userLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_SOCIAL_TYPE", nullable = true)
    private SocialType socialType;

    @Column(name = "USER_JOIN_AT", nullable = false)
    private Timestamp joinAt;

    @Column(name = "USER_UPDATE_AT")
    private Timestamp updateAt;



}