package com.severo.UD4Act1.service;

import com.severo.UD4Act1.entities.Libro;
import com.severo.UD4Act1.repository.LibroRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }
    public boolean delete(Long id){
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addLibro(Libro libro){
        libroRepository.save(libro);
    }

    public void updateLibro(Libro libro){
        libroRepository.save(libro);
    }

    public Libro findLibroByTitulo(String titulo){
        return libroRepository.findLibroByTitulo(titulo);
    }

    public List<Libro> findLibrosByAutor(String autor){
        return libroRepository.findLibrosByAutor(autor);
    }

    public List<Libro> findLibroByEditorial(String editorial){
        return libroRepository.findLibroByEditorial(editorial);
    }

    public Libro findLibroByIsbn(String isbn){
        return libroRepository.findLibroByIsbn(isbn);
    }

    public Libro findCheapestLibro(){
        Libro libro =libroRepository.findAll(Sort.sort(Libro.class).by(Libro::getPrecio))
                .stream()
                .findFirst()
                .orElse(null);
        return libro;
    }

    public List<Libro> findLibrosByCategoriaNombre(String nombre){
        return libroRepository.findLibrosByCategoriaNombre(nombre);
    }

    public List<Libro> postLibrosList(List<Libro> libros){
        return libroRepository.saveAll(libros);
    }


    public Optional<Libro> find(Long id){
        var libro = libroRepository.findById(id).orElse(null);
        return Optional.ofNullable(libro);
    }

}
