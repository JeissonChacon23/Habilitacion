package com.example.habilitacion.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "habilidad", schema = "public")
public class Habilidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "nuuid", length = 100)
    private String nuuid;

    @ManyToOne
    @JoinColumn(name = "rango_id")
    private Rango rango;

    @ManyToMany(mappedBy = "habilidades")
    private Set<Jugador> jugadores = new HashSet<>();
}
