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
@Table(name = "biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false )
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @JsonBackReference
    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<BibliotecaHasLibro> bibliotecaHasLibros = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "biblioteca")
    private List<Usuario> usuarios;

    @JsonIgnore
    @OneToMany(mappedBy = "biblioteca")
    private List<Reserva> reservas;

}
