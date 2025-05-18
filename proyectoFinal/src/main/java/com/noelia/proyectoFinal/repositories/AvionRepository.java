package com.noelia.proyectoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noelia.proyectoFinal.entitys.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

    // Buscar todos los aviones disponibles

	
}
