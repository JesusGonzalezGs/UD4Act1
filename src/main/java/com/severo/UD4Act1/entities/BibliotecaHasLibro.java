package com.severo.UD4Act1.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "biblioteca_has_libro")
public class BibliotecaHasLibro {

    @JsonBackReference
    @EmbeddedId
    private BibliotecaHasLibroId id;


    @JsonBackReference
    @MapsId("IdBiblioteca")
    @ManyToOne(optional = false)
    @JoinColumn(name = "biblioteca_id", nullable = false)
    private Biblioteca biblioteca;

    @JsonBackReference
    @MapsId("idLibro")
    @ManyToOne( optional = false)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @Column(name = "stock", nullable = false)
    private Integer stock;



    

}
