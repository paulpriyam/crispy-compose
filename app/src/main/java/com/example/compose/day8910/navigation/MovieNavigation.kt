package com.example.compose.day8910.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.compose.day8910.ListScreen


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.ListScreen.name) {

        composable(MovieScreens.ListScreen.name) {
            ListScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") {
                type =
                    NavType.StringType
            })
        ) { backStackEntry ->
            DetailScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }
    }
}