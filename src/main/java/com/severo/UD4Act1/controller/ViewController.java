package com.severo.UD4Act1.controller;


import com.severo.UD4Act1.entities.Biblioteca;
import com.severo.UD4Act1.entities.Categoria;
import com.severo.UD4Act1.entities.Libro;
import com.severo.UD4Act1.repository.CategoriaRepository;
import com.severo.UD4Act1.service.BibliotecaService;
import com.severo.UD4Act1.service.CategoriaService;
import com.severo.UD4Act1.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final LibroService libroService;
    private final BibliotecaService bibliotecaService;
    private final CategoriaService categoriaService;

    public ViewController(LibroService libroService, BibliotecaService bibliotecaService, CategoriaService categoriaService) {
        this.libroService = libroService;
        this.bibliotecaService = bibliotecaService;
        this.categoriaService = categoriaService;
    }


    @GetMapping
    public String homePage(){
        return "redirect:/view/libros";
    }

    @GetMapping("/libros")
    public String getLibros(Model model){
        model.addAttribute("libros", libroService.findAll());
        return "libro/libros";
    }

    @GetMapping("/libros/add")
    public String addLibro(Model model){
        Libro libro = new Libro();
        libro.setCategoria(new Categoria());
        model.addAttribute("libro",libro);
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        return "libro/add";
    }

    @PostMapping("/libros/save")
    public String saveLibro(@ModelAttribute("libro") Libro libro){
        libro.setCategoria(categoriaService.findCategoriaById(libro.getCategoria().getId()).orElse(null));
        libroService.addLibro(libro);

        return "redirect:/view/libros";
    }

    @GetMapping("/libros/update/{id}")
    public String updateLibro(@PathVariable(value = "id") Long id, Model model){
        Libro libro = libroService.find(id).orElse(null);
        if (libro == null)
            return "redirect:/view/libros";
        model.addAttribute("libro", libro);
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);

        return "libro/update";
    }


    @GetMapping("/libros/delete/{id}")
    public String deleteLibro(@PathVariable(value = "id") Long id){
        libroService.delete(id);
        return "redirect:/view/libros";
    }

    @GetMapping("/bibliotecas")
    public String getBibliotecas(Model model){
        model.addAttribute("bibliotecas", bibliotecaService.findAll());
        return "biblioteca/bibliotecas";
    }

    @GetMapping("/bibliotecas/add")
    public String addBiblioteca(Model model){
        model.addAttribute("biblioteca",new Biblioteca());
        return "biblioteca/add";
    }


    @PostMapping("/bibliotecas/save")
    public String saveBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca){
        bibliotecaService.addBiblioteca(biblioteca);
        return "redirect:/view/bibliotecas";
    }

    @GetMapping("/bibliotecas/update/{id}")
    public String updateBiblioteca(@PathVariable(value = "id") Long id, Model model){
        Biblioteca biblioteca = bibliotecaService.findById(id).orElse(null);
        if (biblioteca == null)
            return "redirect:/view/bibliotecas";
        model.addAttribute("biblioteca", biblioteca);
        return "biblioteca/update";
    }

    @GetMapping("/bibliotecas/delete/{id}")
    public String deleteBiblioteca(@PathVariable(value = "id") Long id){
        bibliotecaService.delete(id);
        return "redirect:/view/bibliotecas";
    }
}
