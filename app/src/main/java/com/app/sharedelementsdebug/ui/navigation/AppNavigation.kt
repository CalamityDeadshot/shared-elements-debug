package com.app.sharedelementsdebug.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.sharedelementsdebug.ui.screens.DetailScreen
import com.app.sharedelementsdebug.ui.screens.ListScreen


sealed class AppScreen(val route: String) {
    object List: AppScreen("list-screen")
    object Detail: AppScreen("detail-screen/{id}") {
        val navLink = "detail-screen"
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.List.route
    ) {
        composable(
            route = AppScreen.List.route
        ) {
            ListScreen(navController)
        }

        composable(
            route = AppScreen.Detail.route
        ) {
            DetailScreen(id = it.arguments?.getString("id")!!)
        }
    }
}