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

    public List<Avion> obtenerTodos() {
        return avionRepository.findAll();
    }

    public Optional<Avion> obtenerPorId(Long id) {
        return avionRepository.findById(id);
    }

    public Avion guardar(Avion avion) {
        return avionRepository.save(avion);
    }

    public void eliminar(Long id) {
        avionRepository.deleteById(id);
    }

}
