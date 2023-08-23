package com.project.springsecurity.auth.service;

import com.project.springsecurity.auth.request.AuthenticationRequest;
import com.project.springsecurity.auth.request.RegisterRequest;
import com.project.springsecurity.auth.response.AuthResponse;
import com.project.springsecurity.config.JwtService;
import com.project.springsecurity.user.Role;
import com.project.springsecurity.user.User;
import com.project.springsecurity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @className: AuthService
 * @date: 19.07.2023
 * @author: Uralbaev Diyorbek
 */

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Role.USER)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
