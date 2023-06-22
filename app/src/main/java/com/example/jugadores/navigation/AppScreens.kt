package com.example.jugadores.navigation

sealed class AppScreens(val route: String) {
    object MainScreen: AppScreens("main_screen")
    object Info: AppScreens("info_screen")
}
