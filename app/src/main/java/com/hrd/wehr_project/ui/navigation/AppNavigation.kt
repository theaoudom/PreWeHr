package com.hrd.wehr_project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hrd.wehr_project.ui.screen.auth.LoginScreen
import com.hrd.wehr_project.ui.screen.main.MainScreen

@Composable
fun AppNavigation(navController: NavHostController, isAuthenticated: Boolean){
    if (isAuthenticated){
        MainScreen(navController = navController)
    }else{
        LoginScreen()
    }
}