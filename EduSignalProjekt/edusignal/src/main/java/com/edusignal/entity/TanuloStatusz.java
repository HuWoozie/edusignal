package com.edusignal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tanulo_statusz")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TanuloStatusz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tanulo_id", nullable = false)
    private Felhasznalok tanulo;

    @ManyToOne
    @JoinColumn(name = "oktato_id", nullable = false)
    private Felhasznalok oktato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatuszTipus tipus;

    @Column(nullable = false)
    private LocalDate datum;

    @Column(nullable = true)
    private Integer kesesPerc;

    @Column(nullable = true)
    private String uzenet;

    @Column(nullable = false)
    private Boolean latta;

    @Column(name = "latta_datum", nullable = true)
    private LocalDateTime lattaDatum;

    @Column(nullable = false, unique = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, unique = false, updatable = true)
    private LocalDateTime updatedAt;
}
