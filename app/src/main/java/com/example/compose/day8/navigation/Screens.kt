package com.example.compose.day8.navigation

enum class Screens {
    ListScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): Screens =
            when (route?.substringBefore("/")) {
                ListScreen.name -> ListScreen
                DetailScreen.name -> DetailScreen
                null -> ListScreen
                else -> throw IllegalArgumentException("Route $route not recognised")
            }
    }
}