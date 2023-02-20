package com.severo.UD4Act1.controller;


import com.severo.UD4Act1.entities.Biblioteca;
import com.severo.UD4Act1.entities.Libro;
import com.severo.UD4Act1.entities.Reserva;
import com.severo.UD4Act1.entities.Usuario;
import com.severo.UD4Act1.service.BibliotecaService;
import com.severo.UD4Act1.service.LibroService;
import com.severo.UD4Act1.service.ReservaService;
import com.severo.UD4Act1.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Show all bibliotecas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the bibliotecas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Biblioteca.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/bibliotecas")
    public List<Biblioteca> getBibliotecas(){
        return bibliotecaService.findAll();
    }

    @Operation(summary = "Show all libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the libros",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Libro.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/libros")
    public List<Libro> getLibros(){
        return libroService.findAll();
    }


    @Operation(summary = "Show all usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the usuarios",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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

    @GetMapping("/libros/{categoria}")
    public List<Libro> getLibrosByCategoria(@PathVariable String categoria){
        return libroService.findLibrosByCategoriaNombre(categoria);
    }

    @PostMapping("/libros-list")
    public List<Libro> postLibrosList(@RequestBody List<Libro> libros){
        return libroService.postLibrosList(libros);
    }


    @PostMapping("/usuario")
    public Usuario postUsuario(@RequestBody Usuario usuario){
        return usuarioService.addUsuario(usuario);
    }

    @PutMapping("/change-usuario")
    public Usuario putUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/biblioteca/{biblioteca}/{libro}")
    public boolean deleteLibroFromBiblioteca(@PathVariable String biblioteca, @PathVariable String libro){
        return bibliotecaService.deleteLibro(biblioteca, libro);
    }

}
