package com.example.habilitacion.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Data
@Entity
@Table(name = "rango", schema = "public")
public class Rango implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "nuuid", length = 100)
    private String nuuid;
}