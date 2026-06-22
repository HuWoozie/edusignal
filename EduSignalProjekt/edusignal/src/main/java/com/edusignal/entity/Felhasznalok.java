package com.edusignal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="felhasznalok")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Felhasznalok{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "firstname", nullable = false, length = 100, unique = false)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 100, unique = false)
    private String lastname;

    @Column( name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column( name = "password", nullable = false, length = 255, unique = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false, unique = true, columnDefinition = "CHAR(36)")
    private String guid;

    @Column(nullable = false, unique = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, unique = false, updatable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = false, updatable = false)
    private LocalDateTime deletedAt;

    @Column(nullable = false, unique = false, updatable = true)
    private boolean isDeleted;

}
