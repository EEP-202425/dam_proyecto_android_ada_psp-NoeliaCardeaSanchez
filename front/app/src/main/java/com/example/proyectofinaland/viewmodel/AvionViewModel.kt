package com.example.proyectofinaland.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinaland.apicontroller.ApiController
import com.example.proyectofinaland.model.Avion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AvionViewModel : ViewModel() {

    // 1️⃣ Estados
    private val _aviones = MutableStateFlow<List<Avion>>(emptyList())
    val aviones: StateFlow<List<Avion>> = _aviones

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    // 2️⃣ Servicio Retrofit
    private val service = ApiController.avionService

    init {
        cargarAviones()
    }

    // 3️⃣ Cargar lista de aviones
    fun cargarAviones() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _aviones.value = service.getAviones()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }

    // 4️⃣ Crear un nuevo avión
    fun crearAvion(
        nombre: String,
        modelo: String,
        matricula: String,
        onDone: () -> Unit = {}
    ) {
        viewModelScope.launch {
            _loading.value = true
            try {
                // id temporal (se ignora en el backend)
                val nuevo = Avion(0L, nombre, modelo, matricula)
                service.crearAvion(nuevo)
                _aviones.value = service.getAviones()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
                onDone()
            }
        }
    }

    // 5️⃣ Asignar piloto
    fun asignarPiloto(
        avionId: Long,
        pilotoId: Long,
        onDone: () -> Unit = {}
    ) {
        viewModelScope.launch {
            _loading.value = true
            try {
                service.asignarPiloto(avionId, mapOf("pilotoId" to pilotoId))
                _aviones.value = service.getAviones()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
                onDone()
            }
        }
    }
}