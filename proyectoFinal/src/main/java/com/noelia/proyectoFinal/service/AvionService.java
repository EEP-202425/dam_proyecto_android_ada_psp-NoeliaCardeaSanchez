package com.noelia.proyectoFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noelia.proyectoFinal.entitys.Avion;
import com.noelia.proyectoFinal.repositories.AvionRepository;

@Service
public class AvionService {

    private final AvionRepository avionRepository;

    @Autowired
    public AvionService(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    // Obtener todos los aviones
    public List<Avion> obtenerTodos() {
        return avionRepository.findAll();
    }

    // Obtener solo los aviones disponibles
    public List<Avion> obtenerDisponibles() {
        return avionRepository.findByDisponibleTrue();
    }

    // Buscar avión por ID
    public Optional<Avion> obtenerPorId(Long id) {
        return avionRepository.findById(id);
    }

    // Guardar o actualizar un avión
    public Avion guardar(Avion avion) {
        return avionRepository.save(avion);
    }

    // Eliminar un avión por ID
    public void eliminar(Long id) {
        avionRepository.deleteById(id);
    }

}
