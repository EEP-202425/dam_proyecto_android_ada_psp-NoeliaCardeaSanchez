package com.noelia.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noelia.proyectoFinal.entitys.Avion;
import com.noelia.proyectoFinal.service.AvionService;

@RestController
@RequestMapping("/api/aviones")
@CrossOrigin(origins = "*") // Permite peticiones desde otras apps (como Android)
public class AvionController {

    private final AvionService avionService;

    @Autowired
    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    // Obtener todos los aviones
    @GetMapping
    public List<Avion> obtenerTodos() {
        return avionService.obtenerTodos();
    }

    // Obtener aviones disponibles
    @GetMapping("/disponibles")
    public List<Avion> obtenerDisponibles() {
        return avionService.obtenerDisponibles();
    }

    // Obtener un avión por ID
    @GetMapping("/{id}")
    public Optional<Avion> obtenerPorId(@PathVariable Long id) {
        return avionService.obtenerPorId(id);
    }

    // Crear o editar un avión
    @PostMapping
    public Avion guardar(@RequestBody Avion avion) {
        return avionService.guardar(avion);
    }

    // Eliminar un avión por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        avionService.eliminar(id);
    }
}