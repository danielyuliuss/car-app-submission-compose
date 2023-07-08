package com.danielys.myapplication.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailCar : Screen("home/{carId}") {
        fun createRoute(carId: Long) = "home/$carId"
    }
}