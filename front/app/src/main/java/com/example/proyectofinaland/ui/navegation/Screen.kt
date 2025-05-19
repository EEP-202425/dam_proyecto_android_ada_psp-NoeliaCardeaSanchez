package com.example.proyectofinaland.ui.navegation

sealed class Screen(val route: String) {
    object Listado : Screen("listado")
    object Anadir  : Screen("anadir")
}