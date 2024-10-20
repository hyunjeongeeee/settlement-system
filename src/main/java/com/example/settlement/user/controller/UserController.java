package com.example.settlement.user.controller;

import com.example.settlement.jwt.JwtToken;
import com.example.settlement.user.dto.JoinRequestDTO;
import com.example.settlement.user.dto.LoginRequestDTO;
import com.example.settlement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<JoinRequestDTO> signUp(@RequestBody JoinRequestDTO joinRequestDTO) {
        JoinRequestDTO saveUserDTO = userService.signUp(joinRequestDTO);
        return ResponseEntity.ok(saveUserDTO);
    }

    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody LoginRequestDTO loginRequestDTO) {
        String loginId = loginRequestDTO.getLoginId();
        String password = loginRequestDTO.getPassword();

        JwtToken jwtToken = userService.signIn(loginRequestDTO);
        log.info("request loginId = {}, password = {}", loginId, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }

}
