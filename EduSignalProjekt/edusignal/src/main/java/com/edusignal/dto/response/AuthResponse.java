package com.edusignal.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AuthResponse {

    private Integer id;
    private String firstname;
    private String lastname;
    private String token;
    private String role;

}
