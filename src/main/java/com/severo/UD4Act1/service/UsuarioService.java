package com.severo.UD4Act1.service;

import com.severo.UD4Act1.entities.Usuario;
import com.severo.UD4Act1.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findUsuarioByEmail(String email, String password){
        var usuario = usuarioRepository.findUsuarioByEmailAndPassword(email, password);
        return Optional.ofNullable(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public List<Usuario> findAll(Integer page, Integer size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Usuario> pageUsuario = usuarioRepository.findAll(pageable);
        if (pageUsuario.hasContent()){
            return pageUsuario.getContent();
        }else
            return null;
    }
    public List<Usuario> findUsuarioByNombre(String nombre){
        return usuarioRepository.findUsuarioByNombre(nombre);
    }

    public List<Usuario> findUsuarioByBibliotecaId(Long id){
        return usuarioRepository.findUsuarioByBibliotecaId(id);
    }

    public void addUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean delete(Long id){
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Usuario> findUsuarioById(Long id){
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return Optional.ofNullable(usuario);
    }

    public void updateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }


}
