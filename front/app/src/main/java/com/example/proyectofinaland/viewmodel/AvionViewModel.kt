package com.example.proyectofinaland.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinaland.dto.ResponseAvion
import com.example.proyectofinaland.model.Avion
import com.example.proyectofinaland.repositorio.AvionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AvionViewModel : ViewModel() {
    private val repo = AvionRepository()

    // Sólo mantenemos la lista de aviones
    private val _aviones = MutableStateFlow<List<Avion>>(emptyList())
    val aviones: StateFlow<List<Avion>> = _aviones.asStateFlow()

    init {
        cargarAviones()
    }

    fun cargarAviones() {
        viewModelScope.launch {
            _aviones.value = repo.getAviones()
        }
    }

    fun agregarAvion(avion: ResponseAvion, onComplete: () -> Unit) {
        viewModelScope.launch {
            repo.crearAvion(avion)
            _aviones.value = repo.getAviones()
            onComplete()
        }
    }
}
