package com.marceloneuro.jwtsecurity.dtos.auth;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthenticationResponseDTO {
    private String token;
}
