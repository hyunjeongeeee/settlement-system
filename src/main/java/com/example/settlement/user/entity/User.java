package com.example.settlement.user.entity;

import com.example.settlement.user.enums.SocialLoginType;
import com.example.settlement.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import java.security.Timestamp;
import java.util.Collection;
import java.util.Collections;

@Table(name = "USERS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId; // 순번

    @Column(name = "LOGIN_ID", nullable = false, length = 100)
    private String loginId; // 로그인할때쓰는 아이디

    @Column(name = "USER_NICKNAME", nullable = false, length = 100)
    private String userNickname; // 닉네임

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "USER_EMAIL", nullable = false, unique = true, length = 255)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private UserRole userRole;


    // OAuth 로그인에 사용
    @Enumerated(EnumType.STRING)
    @Column(name = "SOCIAL_LOGIN_TYPE")
    private SocialLoginType socialLoginType;

    @Column(name = "SOCIAL_LOGIN_ID")
    private String socialLoginId;

    @CreationTimestamp
    @Column(name = "USER_JOIN_AT")
    private Timestamp joinAt;

    @UpdateTimestamp
    @Column(name = "USER_UPDATE_AT")
    private Timestamp updateAt;

    @Builder
    public User(Long userId, String loginId, String userNickname, String password, String userEmail, UserRole userRole, SocialLoginType socialLoginType, String socialLoginId, Timestamp joinAt, Timestamp updateAt) {
        this.userId = userId;
        this.loginId = loginId;
        this.userNickname = userNickname;
        this.password = password;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.socialLoginType = socialLoginType;
        this.socialLoginId = socialLoginId;
        this.joinAt = joinAt;
        this.updateAt = updateAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.userRole.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}