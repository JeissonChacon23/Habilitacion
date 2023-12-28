package com.example.habilitacion.repository;

import com.example.habilitacion.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {
    //Optional<Clase> findByNuuid(String nuuid);
}