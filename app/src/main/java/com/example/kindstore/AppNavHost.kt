package com.example.kindstore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kindstore.ui.BookmarkScreen
import com.example.kindstore.ui.HomeScreen
import com.example.kindstore.ui.SearchScreen

// Step2 : Screens을 가진 NavHost 정의
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.BookMark.route) {
            BookmarkScreen()
        }
    }
}

