package com.example.proyectofinaland.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectofinaland.dto.ResponseAvion
import com.example.proyectofinaland.model.Avion
import kotlinx.coroutines.delay

//Estados de la UI
sealed class AvionUiState {
    object Loading                 : AvionUiState()
    data class Success(val aviones: List<Avion>) : AvionUiState()
    data class Created(val avion: Avion)         : AvionUiState()
}

// Pantalla principal que despacha según el estado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvionScreen(
    uiState: AvionUiState,
    navController: NavHostController,
    onCreateAvion: (Avion) -> Unit,
    onReload:     () -> Unit,
    modifier:     Modifier = Modifier
) {
    when (uiState) {
        is AvionUiState.Success -> Scaffold(
            topBar = { TopAppBar(title = { Text("Listado de aviones") }) },
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate("crear") }) {
                    Icon(Icons.Default.Add, contentDescription = "Crear avión")
                }
            }
        ) { padding ->
            ShowAviones(
                aviones       = uiState.aviones,
                onItemClick   = { },
                modifier      = modifier
                    .fillMaxSize()
                    .padding(padding),
                onRefresh     = onReload
            )
        }

        is AvionUiState.Created -> CreatedScreenAvion(
            avion    = uiState.avion,
            modifier = modifier.fillMaxSize()
        ).also {
            // tras mostrar el check, vuelve atrás pasado un instante
            LaunchedEffect(uiState.avion.id) {
                delay(1_000)
                navController.popBackStack()
            }
        }

        AvionUiState.Loading -> TODO()
    }
}

// Formulario para crear un avión
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAnadirAvion(
    navController:       NavHostController,
    onCreateAvion: (ResponseAvion) -> Unit,
    modifier:            Modifier = Modifier
) {
    var nombre    by rememberSaveable { mutableStateOf("") }
    var modelo    by rememberSaveable { mutableStateOf("") }
    var matricula by rememberSaveable { mutableStateOf("") }
    var piloto by rememberSaveable { mutableStateOf("") }
    var errorMsg  by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Crear avión") }) }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value     = nombre,
                onValueChange = { nombre = it },
                label     = { Text("Nombre") },
                isError   = nombre.isBlank()
            )
            OutlinedTextField(
                value       = modelo,
                onValueChange = { modelo = it },
                label       = { Text("Modelo") },
                isError     = modelo.isBlank()
            )
            OutlinedTextField(
                value       = matricula,
                onValueChange = { matricula = it },
                label       = { Text("Matrícula") },
                isError     = matricula.isBlank()
            )

            errorMsg?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = {
                    if (nombre.isBlank() || modelo.isBlank() || matricula.isBlank()) {
                        errorMsg = "Rellena todos los campos"
                        return@Button
                    }
                    val nuevo = ResponseAvion(
                        nombre    = nombre.trim(),
                        modelo    = modelo.trim(),
                        matricula = matricula.trim()
                    )

                    onCreateAvion(nuevo)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar avión")
            }
        }
    }
}

//Lista de aviones
@Composable
fun ShowAviones(
    aviones:     List<Avion>,
    onItemClick: (Long) -> Unit,
    onRefresh:   () -> Unit,
    modifier:    Modifier = Modifier
) {
    if (aviones.isEmpty()) {
        LaunchedEffect(Unit) { onRefresh() }
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Text("No hay aviones aún")
        }
    } else {
        LazyColumn(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(aviones) { avion ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(avion.id) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(text = avion.nombre, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Modelo: ${avion.modelo}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Matrícula: ${avion.matricula}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

//Pantalla de “avión creado”
@Composable
fun CreatedScreenAvion(
    avion:    Avion,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment   = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector   = Icons.Default.CheckCircle,
            contentDescription = "Creado",
            modifier      = Modifier.size(80.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text("Avión \"${avion.nombre}\" creado con éxito", style = MaterialTheme.typography.headlineSmall)
    }
}

