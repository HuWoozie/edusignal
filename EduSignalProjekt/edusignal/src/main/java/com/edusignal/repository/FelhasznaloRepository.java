package com.edusignal.repository;

import com.edusignal.entity.Felhasznalok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FelhasznaloRepository extends JpaRepository<Felhasznalok, Integer> {

    Optional<Felhasznalok> findByEmail(String email);

    Optional<Felhasznalok> findById(Integer id);

}
