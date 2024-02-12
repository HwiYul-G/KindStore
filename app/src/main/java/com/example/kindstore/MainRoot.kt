package com.example.kindstore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainRoot() {
    val navController = rememberNavController()
    val items = listOf(BottomNavigationItem.Home, BottomNavigationItem.Search, BottomNavigationItem.BookMark)
    val showBottomNavBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in items.map { it.route }
    Scaffold(bottomBar = {
        AnimatedVisibility(
            visible = showBottomNavBar,
        ) {
            BottomNavigationBar(
                navController = navController,
                items = items,
            )
        }
    }) {
        AppNavHost(
            modifier = Modifier.padding(it),
            navController = navController,
        )
    }
}