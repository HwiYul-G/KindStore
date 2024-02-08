package com.example.kindstore

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

// Step1 : screens name과 route 정의
enum class Screen{
    Home,
    Search,
    BookMark,
}

sealed class NavigationItem(val route : String, @StringRes val resourceId: Int, val icon: ImageVector){
    object Home : NavigationItem(Screen.Home.name, R.string.home, Icons.Filled.Home)
    object Search : NavigationItem(Screen.Search.name, R.string.search, Icons.Filled.Search)
    object BookMark : NavigationItem(Screen.BookMark.name, R.string.bookmark, Icons.Outlined.Star)
}