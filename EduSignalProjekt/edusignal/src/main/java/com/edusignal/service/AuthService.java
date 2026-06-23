package com.edusignal.service;

import com.edusignal.dto.request.LoginRequest;
import com.edusignal.dto.request.RegisterRequest;
import com.edusignal.dto.response.AuthResponse;
import com.edusignal.entity.Felhasznalok;
import com.edusignal.entity.Role;
import com.edusignal.repository.FelhasznaloRepository;
import com.edusignal.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final FelhasznaloRepository felhasznaloRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        Felhasznalok felhasznalo = Felhasznalok.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.TANULO)
                .guid(UUID.randomUUID().toString())
                .build();

        felhasznaloRepository.save(felhasznalo);

        String token = jwtService.generateToken(felhasznalo.getId());

        return AuthResponse.builder()
                .id(felhasznalo.getId())
                .firstname(felhasznalo.getFirstname())
                .lastname(felhasznalo.getLastname())
                .token(token)
                .role(felhasznalo.getRole().name())
                .build();
    }

    // LOGIN -----------------------------------------------------
    public AuthResponse login(LoginRequest request) {
        Felhasznalok felhasznalo = felhasznaloRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Hibás email vagy jelszó"));

        if (!passwordEncoder.matches(request.getPassword(), felhasznalo.getPassword())) {
            throw new RuntimeException("Hibás email vagy jelszó");
        }

        String token = jwtService.generateToken(felhasznalo.getId());

        return AuthResponse.builder()
                .id(felhasznalo.getId())
                .firstname(felhasznalo.getFirstname())
                .lastname(felhasznalo.getLastname())
                .token(token)
                .role(felhasznalo.getRole().name())
                .build();
    }

}


