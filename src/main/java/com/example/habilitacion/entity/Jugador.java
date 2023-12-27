package com.example.habilitacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Data
public class Jugador implements Serializable {
    @Id
    @Column(nullable=false)
    private Integer id;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name = "clase_id")
    private Integer clase;
    @Column(name = "genero")
    private String genero;
    @Column(name = "rango")
    private Integer rango;
    @Column(name = "rango_id")
    private Integer nuuid;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "jugadores")
    private List<Habilidad> habilidades = new ArrayList<>();
}