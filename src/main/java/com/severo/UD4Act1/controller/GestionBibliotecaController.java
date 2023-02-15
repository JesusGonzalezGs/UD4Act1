package com.severo.UD4Act1.controller;


import com.severo.UD4Act1.entities.Biblioteca;
import com.severo.UD4Act1.entities.Libro;
import com.severo.UD4Act1.entities.Reserva;
import com.severo.UD4Act1.entities.Usuario;
import com.severo.UD4Act1.service.BibliotecaService;
import com.severo.UD4Act1.service.LibroService;
import com.severo.UD4Act1.service.ReservaService;
import com.severo.UD4Act1.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/apiBiblioteca")
public class GestionBibliotecaController {

    private final BibliotecaService bibliotecaService;
    private final LibroService libroService;

    private final UsuarioService usuarioService;

    private final ReservaService reservaService;



    public GestionBibliotecaController(BibliotecaService bibliotecaService, LibroService libroService, UsuarioService usuarioService, ReservaService reservaService) {
        this.bibliotecaService = bibliotecaService;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
    }

    @GetMapping("/bibliotecas")
    public List<Biblioteca> getBibliotecas(){
        return bibliotecaService.findAll();
    }

    @GetMapping("/libros")
    public List<Libro> getLibros(){
        return libroService.findAll();
    }


    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios-page")
    public List<Usuario> getUsuarios(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy){
        return usuarioService.findAll(page-1, size, sortBy);
    }

    @GetMapping("/statistics/reservas/{biblioteca}")
    public String findAllReservaByBibliotecaNombre(@PathVariable String biblioteca){
        String result = "Biblioteca: " + biblioteca + " " + "Reservas: " + reservaService.findAllReservaByBibliotecaNombre(biblioteca);
        return result;
    }


    @GetMapping("/libros/cheapest")
    public Libro getCheapestBook(){
        return libroService.findCheapestLibro();
    }

    @GetMapping("reservas/{biblioteca}/{libro}")
    public List<Reserva> getReservasByBibliotecaAndLibro(@PathVariable String biblioteca, @PathVariable String libro){
        return reservaService.findAllReservaByBibliotecaNombreAndLibroTitulo(biblioteca, libro);
    }

    @GetMapping("/biblioteca/stock/{biblioteca}/{libro}")
    public String getStockByBibliotecaAndLibro(@PathVariable String biblioteca, @PathVariable String libro){
        String result = "Biblioteca: " + biblioteca + " / " + "Libro: " + libro + " / " + "Stock: " + bibliotecaService.ConsultarStockLibro(biblioteca, libro);
        return result;
    }

    @GetMapping("biblioteca/{libro}")
    public List<Biblioteca> getBibliotecasByLibro(@PathVariable String libro){
        return bibliotecaService.findAllBibliotecaByLibro(libro);
    }

    @GetMapping("/reservas")
    public List<Reserva> getReservasByFechaOut(@RequestParam String fechaOut){
        return reservaService.findAllReservaByFechaOut(LocalDate.parse(fechaOut));
    }

}
