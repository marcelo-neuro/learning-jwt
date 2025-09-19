package com.marceloneuro.jwtsecurity.controllers.auth;

import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationReqeustDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationResponseDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.RegisterRequestDTO;
import com.marceloneuro.jwtsecurity.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationReqeustDTO reqeust) {
        return ResponseEntity.ok(authenticationService.authenticate(reqeust));
    }

}
