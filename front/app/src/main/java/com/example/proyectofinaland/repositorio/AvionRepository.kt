package com.example.proyectofinaland.repositorio
import com.example.proyectofinaland.apicontroller.ApiController
import com.example.proyectofinaland.dto.ResponseAvion
import com.example.proyectofinaland.model.Avion

class AvionRepository {
    // Llamadas directas al servicio Retrofit
    suspend fun getAviones(): List<Avion> =
        ApiController.avionService.getAviones()

    suspend fun crearAvion(avion: ResponseAvion): Avion =
        ApiController.avionService.crearAvion(avion)
}