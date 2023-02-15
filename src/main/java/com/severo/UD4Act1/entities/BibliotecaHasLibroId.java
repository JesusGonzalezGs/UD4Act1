package com.severo.UD4Act1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class BibliotecaHasLibroId implements Serializable {
    @Column(name = "biblioteca_id", nullable = false)
    private Long idBiblioteca;

    @Column(name = "libro_id", nullable = false)
    private Long idLibro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibliotecaHasLibroId that = (BibliotecaHasLibroId) o;
        return Objects.equals(idBiblioteca, that.idBiblioteca) && Objects.equals(idLibro, that.idLibro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBiblioteca, idLibro);
    }
}
