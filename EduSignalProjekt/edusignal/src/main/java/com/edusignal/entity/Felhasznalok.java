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

    @Column(nullable = false, length = 100, unique = false)
    private String firstname;

    @Column(nullable = false, length = 100, unique = false)
    private String latname;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255, unique = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(unique = true, nullable = false, length = 36)
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
