package com.example.habilitacion.repository;

import com.example.habilitacion.entity.Clase;
import com.example.habilitacion.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabilidadRepository extends JpaRepository<Clase, Integer> {
    Optional<Habilidad> findByNuuid(String nuuid);
}


