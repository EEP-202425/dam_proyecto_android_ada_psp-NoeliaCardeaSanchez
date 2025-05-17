package com.example.proyectofinaland.ui.navegation

import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyectofinaland.ui.screens.AsignarPiloto
import com.example.proyectofinaland.ui.screens.ListadoAviones
import com.example.proyectofinaland.ui.screens.NuevoAvion

@Composable
fun AppNavHost() {
    val nav = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController = nav, startDestination = "listado") {
            composable("listado") {
                ListadoAviones(nav)
            }
            composable("nuevo") {
                NuevoAvion(nav)
            }
            composable(
                "asignar/{avionId}",
                arguments = listOf(navArgument("avionId") { type = NavType.LongType })
            ) { backStack ->
                val avionId = backStack.arguments!!.getLong("avionId")
                AsignarPiloto(avionId, nav)
            }
        }
    }
}