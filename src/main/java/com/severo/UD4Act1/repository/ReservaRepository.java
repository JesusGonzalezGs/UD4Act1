package com.severo.UD4Act1.repository;

import com.severo.UD4Act1.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findReservaByUsuarioId(Long id);
    List<Reserva> findReservaByLibroId(Long id);
    List<Reserva> findAllReservaByBibliotecaNombre(String nombre);
    void deleteReservaById(Long id);

    List<Reserva> findAllReservaByBibliotecaNombreAndLibroTitulo(String nombre, String titulo);


    List<Reserva> findAllReservaByFechaOut(LocalDate fechaOut);

}
