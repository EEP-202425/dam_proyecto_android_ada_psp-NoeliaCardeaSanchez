package com.example.proyectofinaland.ui.navegation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.proyectofinaland.dto.ResponseAvion

import com.example.proyectofinaland.ui.screens.PantallaAnadirAvion
import com.example.proyectofinaland.ui.screens.ShowAviones
import com.example.proyectofinaland.viewmodel.AvionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val vm: AvionViewModel = viewModel()
    val aviones by vm.aviones.collectAsState()

    NavHost(
        navController    = navController,
        startDestination = Screen.Listado.route,
        modifier         = modifier
    ) {
        // Ruta de listado
        composable(Screen.Listado.route) {
            Scaffold(
                topBar = { TopAppBar(title = { Text("Listado de aviones") }) },
                floatingActionButton = {
                    FloatingActionButton(onClick = { navController.navigate(Screen.Anadir.route) }) {
                        Icon(Icons.Default.Add, contentDescription = "Crear avión")
                    }
                }
            ) { padding ->
                ShowAviones(
                    aviones     = aviones,
                    onItemClick = { /*posible detalle*/ },
                    onRefresh   = { vm.cargarAviones() },
                    modifier    = Modifier
                        .fillMaxSize()
                        .padding(padding)
                )
            }
        }

        // Ruta de creación
        composable(Screen.Anadir.route) {
            PantallaAnadirAvion(
                navController = navController,
                onCreateAvion = { avionDto: ResponseAvion ->
                    vm.agregarAvion(avionDto) {
                        vm.cargarAviones()
                        navController.popBackStack()
                    }
                },
                modifier = modifier
            )
        }
    }
}
