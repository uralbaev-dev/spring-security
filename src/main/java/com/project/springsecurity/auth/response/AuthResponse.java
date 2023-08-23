package com.project.springsecurity.auth.response;

import lombok.*;

/**
 * @className: AuthResponse
 * @date: 19.07.2023
 * @author: Uralbaev Diyorbek
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
}
