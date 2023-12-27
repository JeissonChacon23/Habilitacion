package com.example.habilitacion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Habilidad implements Serializable {
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="nuuid")
    private Integer nuuid;

    @Column(name="rango")
    private Integer rango;

    @ManyToMany
    private List<Jugador> jugadores = new ArrayList<>();
}
