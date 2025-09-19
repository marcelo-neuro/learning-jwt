package com.marceloneuro.jwtsecurity.services.auth;

import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationReqeustDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationResponseDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.RegisterRequestDTO;
import com.marceloneuro.jwtsecurity.entities.Role;
import com.marceloneuro.jwtsecurity.entities.User;
import com.marceloneuro.jwtsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationReqeustDTO reqeust) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reqeust.getEmail(),
                        reqeust.getPassword()
                )
        );

        User user = userRepository.findByEmail(reqeust.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(token)
                .build();
    }
}
