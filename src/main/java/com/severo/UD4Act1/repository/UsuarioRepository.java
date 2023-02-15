package com.severo.UD4Act1.repository;

import com.severo.UD4Act1.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    List<Usuario> findUsuarioByNombre(String nombre, Pageable pageable);
    List<Usuario> findUsuarioByNombre(String nombre);
    Usuario findUsuarioByEmailAndPassword(String email, String password);
    List<Usuario> findUsuarioByBibliotecaId(Long id);
    List<Usuario> findUsuarioByBibliotecaId(Long id, Pageable pageable);




}
