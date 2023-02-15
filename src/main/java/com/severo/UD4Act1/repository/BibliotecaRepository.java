package com.severo.UD4Act1.repository;

import com.severo.UD4Act1.entities.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
    Biblioteca findBibliotecaByNombre(String nombre);
    Biblioteca findBibliotecaByDireccion(String direccion);
    Biblioteca findBibliotecaByTelefono(String telefono);

}
