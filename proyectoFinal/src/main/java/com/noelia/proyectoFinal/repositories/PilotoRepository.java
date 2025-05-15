package com.noelia.proyectoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noelia.proyectoFinal.entitys.Piloto;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
	Piloto findByNombre(String nombre);
}