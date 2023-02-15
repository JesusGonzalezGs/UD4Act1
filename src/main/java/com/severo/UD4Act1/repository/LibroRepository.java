package com.severo.UD4Act1.repository;

import com.severo.UD4Act1.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findLibroByTitulo(String titulo);
    List<Libro> findLibroByAutor(String autor);
    List<Libro> findLibroByEditorial(String editorial);
    Libro findLibroByIsbn(String isbn);



}
