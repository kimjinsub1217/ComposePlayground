package com.jinsub.bottomnavigation.navigation

// sealed class :폐쇄된 클래스 계층을 정의할 때 사용
sealed class NavRoute(val path: String) {
    object Home : NavRoute("home")
    object Profile : NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Settings : NavRoute("settings")

}