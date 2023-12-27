package com.example.habilitacion.controller;

import com.example.habilitacion.entity.Jugador;
import com.example.habilitacion.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/jugadores")
@RestController
public class JugadorController {
    @Autowired
    JugadorRepository jugadorRepository;
    @GetMapping()
    public List<Jugador> getJugadorAll() {

        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores;
    }
    @PostMapping
    public Jugador logIn(@RequestBody Jugador jugador) {
        jugadorRepository.save(jugador);
        return jugador;
    }
    @GetMapping("/{clase}")
    public Jugador getCategoriasbyId(@PathVariable Integer clase) {
        Optional<Jugador> jugador = jugadorRepository.findById(clase);
        if (jugador.isPresent()) {
            return jugador.get();
        }
        return null;
    }
}