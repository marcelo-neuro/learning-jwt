package com.marceloneuro.jwtsecurity.controllers.auth;

import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationReqeustDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.AuthenticationResponseDTO;
import com.marceloneuro.jwtsecurity.dtos.auth.RegisterRequestDTO;
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

    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {


    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationReqeustDTO reqeust) {

    }

}
