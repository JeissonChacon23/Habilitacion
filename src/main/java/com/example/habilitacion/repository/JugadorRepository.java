package com.example.habilitacion.repository;

import com.example.habilitacion.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    List<Jugador> findByClaseId(Integer claseId);
}
