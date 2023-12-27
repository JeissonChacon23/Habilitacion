package com.example.habilitacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@Entity
public class Clase implements Serializable {
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nuuid")
    private Integer nuuid;

    @JsonIgnore
    @OneToMany(mappedBy="clase")
    private List<Jugador> jugadores;
}
