package com.edusignal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name="tantargyak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tantargy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true,length = 100)
    private String nev;

    @Column(nullable = false, unique = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, unique = false, updatable = true)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
