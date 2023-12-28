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
    public List<Jugador> getAllJugadoresByIdClase() {

        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores;
    }
    @GetMapping("/{clase}")
    public List<Jugador> getJugadoresByIdClase(@RequestParam("clase") Integer clase) {
        List<Jugador> jugadores = jugadorRepository.findByClaseId(clase);
        return jugadores;
    }

    @PostMapping("/{nombre}")
    public String getnuuidJugadoresByNombre(@RequestParam("nombre") String nombre) {

        Optional<Jugador> jugador = jugadorRepository.findNuuidByNombre(nombre);

        return jugador.isPresent() ? jugador.get().getNuuid() == null ? "El nuuid del jugador " + nombre +" es nulo" : jugador.get().getNuuid() : "Jugador " + nombre + " No existe";
    }
    /*@PostMapping("/create")
    public Jugador create(@RequestBody Jugador jugador) {
        jugadorRepository.save(jugador);
        return jugador;
    }*/

    /*@PostMapping
    public ResponseEntity<String> crearJugador(@RequestBody Jugador nuevoJugador) {
        try {
            // Puedes hacer validaciones adicionales aquí antes de guardar en la base de datos
            jugadorRepository.save(nuevoJugador);
            return new ResponseEntity<>("Jugador creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el jugador: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */
}