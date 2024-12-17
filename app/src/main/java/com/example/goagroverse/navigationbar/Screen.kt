package com.example.goagroverse.navigationbar

sealed class Screen  (val route: String){

    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    data object Dashboard : Screen("dashboard")
    data object Edukasi : Screen("edukasi")
    data object Komunitas : Screen("komunitas")
    data object Market: Screen("market")
    data object Setting: Screen("setting")

}