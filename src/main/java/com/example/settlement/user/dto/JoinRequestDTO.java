package com.example.settlement.user.dto;

import com.example.settlement.user.entity.User;
import com.example.settlement.user.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JoinRequestDTO {
    private String loginId;
    private String userNickname;
    private String password;
    private String passwordCheck;
    private String userEmail;
    private UserRole userRole;

    public static JoinRequestDTO toDTO (User user, UserRole userRole) {
        return JoinRequestDTO.builder()
                .loginId(user.getLoginId())
                .userNickname(user.getUserNickname())
                .password(user.getPassword())
                .userEmail(user.getUserEmail())
                .userRole(userRole)
                .build();
    }

    public User toEntity(String password) {
        return User.builder()
                .loginId(this.loginId)
                .userNickname(this.userNickname)
                .password(password)
                .userEmail(this.userEmail)
                .userRole(UserRole.SILVER)
                .build();
    }
}