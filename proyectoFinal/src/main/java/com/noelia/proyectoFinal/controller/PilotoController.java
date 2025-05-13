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

import com.noelia.proyectoFinal.entitys.Piloto;
import com.noelia.proyectoFinal.service.PilotoService;

@RestController
@RequestMapping("/api/pilotos")
@CrossOrigin(origins = "*")
public class PilotoController {

    private final PilotoService pilotoService;

    @Autowired
    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @GetMapping
    public List<Piloto> obtenerTodos() {
        return pilotoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Piloto> obtenerPorId(@PathVariable Long id) {
        return pilotoService.obtenerPorId(id);
    }

    @PostMapping
    public Piloto guardar(@RequestBody Piloto piloto) {
        return pilotoService.guardar(piloto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pilotoService.eliminar(id);
    }
}
