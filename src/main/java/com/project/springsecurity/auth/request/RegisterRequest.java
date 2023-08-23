package com.project.springsecurity.auth.request;

import lombok.*;

/**
 * @className: RegisterRequest
 * @date: 19.07.2023
 * @author: Uralbaev Diyorbek
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
