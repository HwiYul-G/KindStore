package com.example.kindstore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

// Step2 : Screens을 가진 NavHost 정의
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Main.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Main.route) {
            // HomeScreen()
        }
        searchGraph(navController = navController)
    }
}

fun NavGraphBuilder.searchGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = NavigationItem.Search.route,
        route = NavigationItem.Search.route
    ) {
        composable(NavigationItem.Search.route) {
            // SearchScreen()
        }
        composable(NavigationItem.Detail.route) {
            // DetailScreen()
        }
    }
}