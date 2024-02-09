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
    ShopDetail
}

sealed class NavigationItem(val route : String){
    object Home : NavigationItem(Screen.Home.name)
    object Search : NavigationItem(Screen.Search.name)
    object BookMark : NavigationItem(Screen.BookMark.name)
    object ShopDetail : NavigationItem(Screen.ShopDetail.name)
}

sealed class BottomNavigationItem(val route : String, @StringRes val resourceId : Int, val icon : ImageVector){
    object Home : BottomNavigationItem(Screen.Home.name, R.string.home, Icons.Default.Home)
    object Search : BottomNavigationItem(Screen.Search.name, R.string.search, Icons.Default.Search)
    object BookMark : BottomNavigationItem(Screen.BookMark.name, R.string.bookmark, Icons.Outlined.Star)
}

