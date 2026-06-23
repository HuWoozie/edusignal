package com.edusignal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="jegyek")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Jegyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "tanulo_id", nullable = false)
    private Felhasznalok tanulo;

    @ManyToOne
    @JoinColumn(name = "oktato_id", nullable = false)
    private Felhasznalok oktato;

    @ManyToOne
    @JoinColumn(name = "tantargy_id", nullable = false)
    private Felhasznalok tantargy;

    @Column( name = "jegy", nullable = false, unique = false, columnDefinition = "TINYINT")
    private Integer jegy;

    @Column( name = "megjegyzes", nullable = true, length = 255)
    private String megjegyzes;

    @Column(nullable = false, unique = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, unique = false, updatable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = false, updatable = true)
    private boolean isDeleted;
}
