package com.severo.UD4Act1.service;

import com.severo.UD4Act1.entities.Reserva;
import com.severo.UD4Act1.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public boolean delete(Long id){
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addReserva(Reserva reserva){
        reservaRepository.save(reserva);
    }

    public void updateReserva(Reserva reserva){
        reservaRepository.save(reserva);
    }

    public List<Reserva> findReservaByUsuarioId(Long id){
        return reservaRepository.findReservaByUsuarioId(id);
    }

    public List<Reserva> findReservaByLibroId(Long id){
        return reservaRepository.findReservaByLibroId(id);
    }

    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findReservaById(Long id){
        var reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return Optional.ofNullable(reserva);
    }

    public int findAllReservaByBibliotecaNombre(String nombre){
        return reservaRepository.findAllReservaByBibliotecaNombre(nombre).size();
    }

    public List<Reserva> findAllReservaByBibliotecaNombreAndLibroTitulo(String nombre, String titulo){
        return reservaRepository.findAllReservaByBibliotecaNombreAndLibroTitulo(nombre, titulo);
    }

    public List<Reserva> findAllReservaByFechaOut(LocalDate fechaOut){
        return reservaRepository.findAllReservaByFechaOut(fechaOut);
    }

}
