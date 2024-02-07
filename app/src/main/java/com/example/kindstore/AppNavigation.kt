package com.example.kindstore

// Step1 : screens name과 route 정의
enum class Screen{
    Home,
    Search,
    Detail,
}

sealed class NavigationItem(val route : String){
    object Main : NavigationItem(Screen.Home.name)
    object Search : NavigationItem(Screen.Search.name)
    object Detail : NavigationItem(Screen.Detail.name)
}