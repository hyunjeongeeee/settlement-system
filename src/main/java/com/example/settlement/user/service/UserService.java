package com.example.settlement.user.service;

import com.example.settlement.jwt.JwtTokenProvider;
import com.example.settlement.jwt.JwtToken;
import com.example.settlement.user.dto.JoinRequestDTO;
import com.example.settlement.user.dto.LoginRequestDTO;
import com.example.settlement.user.enums.UserRole;
import com.example.settlement.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public JoinRequestDTO signUp(JoinRequestDTO joinRequestDTO) {
        // loginId 중복체크
        if (userRepository.existsByLoginId(joinRequestDTO.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        // password 와 passwordCheck 일치하는지 확인
        if (!joinRequestDTO.getPassword().equals(joinRequestDTO.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // UserRole 설정 (기본값 SILVER)
        UserRole userRole = UserRole.SILVER;
        // Password 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDTO.getPassword());
        return JoinRequestDTO.toDTO(userRepository.save(joinRequestDTO.toEntity(encodedPassword)), userRole);
    }



    @Transactional
    public JwtToken signIn(LoginRequestDTO loginRequestDTO) {
        // 1. username + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication 은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginRequestDTO.getLoginId(), loginRequestDTO.getPassword());

        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 User 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        return jwtToken;
    }
}
