package com.noelia.proyectoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noelia.proyectoFinal.entitys.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
