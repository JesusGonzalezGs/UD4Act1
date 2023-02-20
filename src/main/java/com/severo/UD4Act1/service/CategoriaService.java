package com.severo.UD4Act1.service;

import com.severo.UD4Act1.entities.Categoria;
import com.severo.UD4Act1.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public boolean delete(Long id){
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void updateCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public Optional<Categoria> findCategoriaById(Long id){
        var categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return Optional.ofNullable(categoria);


    }
}
