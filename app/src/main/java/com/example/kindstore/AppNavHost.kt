package com.example.kindstore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kindstore.ui.BookmarkScreen
import com.example.kindstore.ui.HomeScreen
import com.example.kindstore.ui.SearchScreen
import com.example.kindstore.ui.ShopDetail

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
            SearchScreen(navController)
        }
        composable(NavigationItem.BookMark.route) {
            BookmarkScreen()
        }
        composable(
            "${NavigationItem.Search.route}/{shopId}",
            arguments = listOf(
                navArgument("shopId") {
                    type = NavType.StringType
                },
            )
        ) {
            val shopId = it.arguments?.getString("shopId")
            shopId?.let { id ->
                ShopDetail(id.toInt(), navController)
            }
        }
    }
}

