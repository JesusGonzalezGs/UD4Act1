package com.severo.UD4Act1.repository;

import com.severo.UD4Act1.entities.Biblioteca;
import com.severo.UD4Act1.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findCategoriaByNombre(String nombre);

}
