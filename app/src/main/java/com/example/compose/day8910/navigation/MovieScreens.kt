package com.example.compose.day8910.navigation

enum class MovieScreens {
    ListScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens =
            when (route?.substringBefore("/")) {
                ListScreen.name -> ListScreen
                DetailScreen.name -> DetailScreen
                null -> ListScreen
                else -> throw IllegalArgumentException("Route $route not recognised")
            }
    }
}