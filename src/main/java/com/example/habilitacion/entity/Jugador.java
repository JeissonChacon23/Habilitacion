package com.example.habilitacion.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "jugador", schema = "public")
public class Jugador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "clase_id")
    private Integer claseId;

    @Column(name = "genero", length = 1)
    private String genero;

    @Column(name = "rango_id")
    private Integer rangoId;

    @Column(name = "nuuid", length = 100)
    private String nuuid;

    @ManyToOne
    @JoinColumn(name = "rango_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Rango rango;

    @ManyToOne
    @JoinColumn(name = "clase_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Clase clase;

    @ManyToMany
    @JoinTable(
            name = "jugador_habilidad",
            joinColumns = @JoinColumn(name = "jugador_id"),
            inverseJoinColumns = @JoinColumn(name = "habilidad_id")
    )
    private Set<Habilidad> habilidades = new HashSet<>();
}