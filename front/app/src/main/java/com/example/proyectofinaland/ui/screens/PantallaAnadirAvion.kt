package com.example.proyectofinaland.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectofinaland.dto.ResponseAvion
import com.example.proyectofinaland.viewmodel.AvionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAnadirAvion(
    navController: NavHostController,
    viewModel: AvionViewModel
) {
    var nombre    by rememberSaveable { mutableStateOf("") }
    var modelo    by rememberSaveable { mutableStateOf("") }
    var matricula by rememberSaveable { mutableStateOf("") }
    var errorMsg  by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Crear avión") }) }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                isError = nombre.isBlank()
            )
            OutlinedTextField(
                value = modelo,
                onValueChange = { modelo = it },
                label = { Text("Modelo") },
                isError = modelo.isBlank()
            )
            OutlinedTextField(
                value = matricula,
                onValueChange = { matricula = it },
                label = { Text("Matrícula") },
                isError = matricula.isBlank()
            )


            errorMsg?.let { Text(it, color = MaterialTheme.colorScheme.error) }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = {
                    val nuevo = ResponseAvion(
                        nombre    = nombre.trim(),
                        modelo    = modelo.trim(),
                        matricula = matricula.trim()
                    )
                    viewModel.agregarAvion(nuevo) {
                        // onComplete
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
