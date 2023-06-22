package com.example.jugadores.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jugadores.Screens.Info
import com.example.jugadores.Screens.MainScreen

@Composable
fun AppNavigation(){
val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen"){
        composable(route = AppScreens.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route=AppScreens.Info.route + "/{Id}",
            arguments = listOf(navArgument("Id"){type = NavType.IntType})){
            Info(navController = navController,it.arguments?.getInt("Id")!!)
        }
    }
}