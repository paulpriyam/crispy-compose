package com.example.compose.day8.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.day8.ListScreen


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.ListScreen.name) {
        composable(MovieScreens.ListScreen.name) {
            ListScreen(navController = navController)
        }
        composable(MovieScreens.DetailScreen.name){
            DetailScreen(navController = navController)
        }
    }
}