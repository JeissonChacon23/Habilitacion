package com.example.habilitacion.controller;

import com.example.habilitacion.entity.Habilidad;
import com.example.habilitacion.entity.Jugador;
import com.example.habilitacion.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        System.out.println("Hello");
        jugadorRepository.save(jugador);
        return jugador;
    }
    /*@GetMapping("/{jugadorId}/habilidades")
    public ResponseEntity<List<Habilidad>> obtenerHabilidadesDeJugador(@PathVariable Integer jugadorId) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(jugadorId);

        if (jugadorOptional.isPresent()) {
            Jugador jugador = jugadorOptional.get();
            List<Habilidad> habilidades = jugador.getHabilidades();
            return ResponseEntity.ok(habilidades);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    /*@GetMapping
    *
    public String getHabilidadesByJugador(@RequestParam("nuuid") String nuuid) {
        Optional<Jugador> jugador = jugadorRepository.findHabilidadesByJugador(nuuid);
    jugador.get().
        return jugador.isPresent() ? jugador.get().getNuuid() == null ? "El nuuid del jugador " + nombre +" es nulo" : jugador.get().getNuuid() : "Jugador " + nombre + " No existe";
    }

     */


}