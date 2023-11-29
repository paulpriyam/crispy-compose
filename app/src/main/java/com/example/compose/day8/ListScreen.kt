package com.example.compose.day8

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ListScreen(navController: NavController) {
    MyApp {
        MainContent(navController)
    }
}