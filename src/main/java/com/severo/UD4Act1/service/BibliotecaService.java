package com.severo.UD4Act1.service;

import com.severo.UD4Act1.entities.Biblioteca;
import com.severo.UD4Act1.entities.BibliotecaHasLibro;
import com.severo.UD4Act1.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public boolean delete(Long id){
        if (bibliotecaRepository.existsById(id)) {
            bibliotecaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.findAll();
    }

    public void saveBiblioteca(Biblioteca biblioteca){
        bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca findBibliotecaByNombre(String nombre){
        return bibliotecaRepository.findBibliotecaByNombre(nombre);
    }

    public Biblioteca findBibliotecaByDireccion(String direccion){
        return bibliotecaRepository.findBibliotecaByDireccion(direccion);
    }

    public Biblioteca findBibliotecaByTelefono(String telefono){
        return bibliotecaRepository.findBibliotecaByTelefono(telefono);
    }

    public int ConsultarStockLibro(String nombre, String titulo){
        Biblioteca biblioteca = bibliotecaRepository.findBibliotecaByNombre(nombre);
        List<Integer> stock = biblioteca.getBibliotecaHasLibros().stream().filter(bibliotecaHasLibro -> bibliotecaHasLibro.getLibro().getTitulo().equals(titulo)).map(BibliotecaHasLibro::getStock).toList();
        return stock.get(0);
    }

    public List<Biblioteca> findAllBibliotecaByLibro(String titulo){
        return bibliotecaRepository.findAll().stream().filter(biblioteca -> biblioteca.getBibliotecaHasLibros().stream().anyMatch(bibliotecaHasLibro -> bibliotecaHasLibro.getLibro().getTitulo().equals(titulo))).collect(Collectors.toList());
    }


}
