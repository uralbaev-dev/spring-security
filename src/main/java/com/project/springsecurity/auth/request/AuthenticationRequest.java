package com.project.springsecurity.auth.request;

import lombok.*;

/**
 * @className: AuthenticationRequest
 * @date: 19.07.2023
 * @author: Uralbaev Diyorbek
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    private String password;
}
