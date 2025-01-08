package com.jinsub.bottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jinsub.bottomnavigation.screens.HomeScreen
import com.jinsub.bottomnavigation.screens.ProfileScreen
import com.jinsub.bottomnavigation.screens.SettingsScreen


@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = NavRoute.Home.path) {
        addHomeScreen(
            navController,
            this
        )
        addProfileScreen(
            navController,
            this
        )
        addSettingsScreen(
            navController,
            this
        )
    }
}

fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ) {
        HomeScreen(
            navigateToProfile = { id, showDetails ->
                navController.navigate(
                    NavRoute.Profile.createRoute(1, false)
                )
            },
            navigateToSettings = {
                navController.navigate(NavRoute.Settings.path)
            }
        )
    }
}

fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            },
            navArgument("showDetails") {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        ProfileScreen(
            id = args?.getInt("id")!!,
            showDetails = args.getBoolean("showDetails"),
            navigateToSettings = { navController.navigate(NavRoute.Settings.path) }
        )
    }
}

fun addSettingsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Settings.path
    ) {
        SettingsScreen(
            navigateToHome = {
                navController
                    .navigate(NavRoute.Home.path)
            }
        )
    }
}

