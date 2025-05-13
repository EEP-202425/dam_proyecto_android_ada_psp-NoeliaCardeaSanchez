package com.noelia.proyectoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noelia.proyectoFinal.entitys.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    
}
