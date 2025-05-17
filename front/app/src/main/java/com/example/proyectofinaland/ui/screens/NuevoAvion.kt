package com.example.proyectofinaland.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectofinaland.viewmodel.AvionViewModel

@Composable
fun NuevoAvion(nav: NavController, vm: AvionViewModel = viewModel()) {
    var nombre by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    val loading by vm.loading.collectAsState()

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matrícula") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                vm.crearAvion(nombre, modelo, matricula) {
                    nav.popBackStack()
                }
            },
            enabled = nombre.isNotBlank() &&
                    modelo.isNotBlank() &&
                    matricula.isNotBlank() &&
                    !loading,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(if (loading) "Creando..." else "Crear Avión")
        }
    }
}