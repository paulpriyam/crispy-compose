package com.example.compose.day8.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController) {
    Text(text = "This is Detail screen")
}