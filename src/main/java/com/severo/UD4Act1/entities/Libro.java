package com.severo.UD4Act1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "editorial", nullable = false)
    private String editorial;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "num_paginas", nullable = false)
    private int numPaginas;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "precio", nullable = false)
    private double precio;

    @JsonBackReference
    @OneToMany(mappedBy = "libro", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<BibliotecaHasLibro> bibliotecaHasLibros = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "libro")
    private List<Reserva> reservas;





}
